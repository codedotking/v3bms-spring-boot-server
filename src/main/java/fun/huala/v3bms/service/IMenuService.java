package fun.huala.v3bms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import fun.huala.v3bms.model.db.MenuEntity;

import java.util.List;


public interface IMenuService extends IService<MenuEntity> {

    /**
     * 获取所有菜单
     *
     * @return 菜单列表
     */
    List<MenuEntity> allMenuList();


    /**
     * 根据角色获取菜单
     *
     * @param role 角色
     * @return 菜单列表
     */
    List<MenuEntity> getMenuListByRole(String role);


}
