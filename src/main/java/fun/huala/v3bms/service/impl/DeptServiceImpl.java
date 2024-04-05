package fun.huala.v3bms.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import fun.huala.v3bms.mapper.DeptMapper;
import fun.huala.v3bms.model.db.DeptEntity;
import fun.huala.v3bms.model.db.MenuEntity;
import fun.huala.v3bms.model.db.MenuMetaEntity;
import fun.huala.v3bms.service.IDeptService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class DeptServiceImpl extends ServiceImpl<DeptMapper, DeptEntity> implements IDeptService {

    @Override
    public List<DeptEntity> list() {
        List<DeptEntity> oneLevelMenus = this.list(Wrappers.lambdaQuery(DeptEntity.class).eq(DeptEntity::getParentId, 0)
                .orderByAsc(DeptEntity::getSort));
        return getChildrenList(oneLevelMenus, false);
    }


    /***
     * 获取子部门
     * @param depts 父级部门
     * @param isDisabled 是否禁用 true 禁用 false 没限制
     * @return menus
     */
    private List<DeptEntity> getChildrenList(List<DeptEntity> depts, boolean isDisabled) {
        depts.forEach(dept -> {
            LambdaQueryWrapper<DeptEntity> childrenWrapper = Wrappers.lambdaQuery(DeptEntity.class)
                    .eq(DeptEntity::getParentId, dept.getId())
                    .orderByAsc(DeptEntity::getSort);
            if (isDisabled) {
                childrenWrapper.eq(DeptEntity::getStatus, 0);
            }
            List<DeptEntity> children = this.list(childrenWrapper);
            if (!children.isEmpty()) {
                dept.setChildren(this.getChildrenList(children, isDisabled));
            }
        });
        return depts;
    }
}
