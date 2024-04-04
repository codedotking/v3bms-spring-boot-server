package fun.huala.v3bms.controller;


import fun.huala.v3bms.model.db.RoleEntity;
import fun.huala.v3bms.model.dto.PageDTO;
import fun.huala.v3bms.model.dto.ResponseDTO;
import fun.huala.v3bms.model.vo.Ids;
import fun.huala.v3bms.model.vo.PageQuery;
import fun.huala.v3bms.service.IRoleService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/sys/role")
@AllArgsConstructor
public class RoleController {

    private final IRoleService roleService;

    /**
     * 获取角色列表
     */
    @GetMapping("/list")
    public ResponseDTO handleRoleList(PageQuery query) {
        PageDTO<RoleEntity> pageDTO = roleService.list(query);
        return new ResponseDTO().setCode(200).setData(pageDTO);
    }


    /**
     * 添加角色
     */
    @PostMapping("")
    public ResponseDTO handleSaveRole(@RequestBody RoleEntity roleEntity) {
        roleService.save(roleEntity);
        return new ResponseDTO().setCode(200).setMessage("保存成功");
    }

    /**
     * 更新角色信息
     */
    @PutMapping("")
    public ResponseDTO handleUpdateRole(@RequestBody RoleEntity roleEntity) {
        roleService.updateById(roleEntity);
        return new ResponseDTO().setCode(200).setMessage("更新成功成功");
    }

    /**
     * 批量删除角色
     */
    @DeleteMapping("")
    public ResponseDTO handleBatchDeleteRole(@RequestBody Ids ids) {
        roleService.removeByIds(ids.getIds());
        return new ResponseDTO().setCode(200).setMessage("删除成功");
    }


}
