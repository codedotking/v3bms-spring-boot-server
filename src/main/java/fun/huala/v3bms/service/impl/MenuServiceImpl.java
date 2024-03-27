package fun.huala.v3bms.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import fun.huala.v3bms.mapper.MenuMapper;
import fun.huala.v3bms.model.db.MenuEntity;
import fun.huala.v3bms.model.db.MenuMetaEntity;
import fun.huala.v3bms.service.IMenuMetaService;
import fun.huala.v3bms.service.IMenuService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Slf4j
@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, MenuEntity> implements IMenuService {

    private final IMenuMetaService menuMetaService;

    @Autowired
    public MenuServiceImpl(IMenuMetaService menuMetaService) {
        this.menuMetaService = menuMetaService;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean save(MenuEntity entity) {
        boolean res = baseMapper.insert(entity) > 0;
        MenuMetaEntity menuMeta = entity.getMeta();
        menuMeta.setMenuId(entity.getId());
        res = res && menuMetaService.save(menuMeta);
        return res;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean updateById(MenuEntity menu) {
        boolean res = baseMapper.updateById(menu) > 0;
        MenuMetaEntity menuMeta = menu.getMeta();
        LambdaQueryWrapper<MenuMetaEntity> updateWrapper = Wrappers.lambdaQuery(MenuMetaEntity.class)
                .eq(MenuMetaEntity::getMenuId, menu.getId());
        log.info("baseMapper.updateById = {}", res);
        res = res && menuMetaService.update(menuMeta, updateWrapper);
        return res;
    }

    @Override
    public List<MenuEntity> allMenuList() {
        // 获取一级菜单
        List<MenuEntity> oneLevelMenus = this.list(Wrappers.lambdaQuery(MenuEntity.class).eq(MenuEntity::getParentId, 0).orderByAsc(MenuEntity::getSort));
        // 获取子菜单
        return this.getChildrenList(oneLevelMenus, false);
    }


    /***
     * 获取子菜单
     * @param menus 父级菜单
     * @param isDisabled 是否禁用 true 禁用 false 没限制
     * @return menus
     */
    private List<MenuEntity> getChildrenList(List<MenuEntity> menus, boolean isDisabled) {
        menus.forEach(menu -> {
            LambdaQueryWrapper<MenuMetaEntity> wrapper = Wrappers.lambdaQuery(MenuMetaEntity.class)
                    .eq(MenuMetaEntity::getMenuId, menu.getId());
            menu.setMeta(menuMetaService.getOne(wrapper));

            LambdaQueryWrapper<MenuEntity> childrenWrapper = Wrappers.lambdaQuery(MenuEntity.class)
                    .eq(MenuEntity::getParentId, menu.getId())
                    .orderByAsc(MenuEntity::getSort);
            if (isDisabled) {
                childrenWrapper.eq(MenuEntity::isDisabled, 0);
            }
            List<MenuEntity> children = this.list(childrenWrapper);
            if (children.size() > 0) {
                menu.setChildren(this.getChildrenList(children, isDisabled));
            }
        });
        return menus;
    }


    @Override
    public List<MenuEntity> getMenuListByRole(String role) {
        LambdaQueryWrapper<MenuEntity> wrapper = Wrappers.lambdaQuery(MenuEntity.class)
                .eq(MenuEntity::getParentId, 0)
                .orderByAsc(MenuEntity::getSort)
                .eq(MenuEntity::isDisabled, 0);
        // 获取一级菜单
        List<MenuEntity> oneLevelMenus = this.list(wrapper);
        // 获取子菜单
        return this.getChildrenList(oneLevelMenus, true);
    }


}
