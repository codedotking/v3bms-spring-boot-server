package fun.huala.v3bms.controller;

import fun.huala.v3bms.model.db.MenuEntity;
import fun.huala.v3bms.model.dto.ResponseDTO;
import fun.huala.v3bms.model.vo.IdsForm;
import fun.huala.v3bms.service.IMenuService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author huala-fun
 * @date 2024/3/26
 */
@Slf4j
@RestController
@RequestMapping("/sys/menu")
public class MenuController {
    private final IMenuService menuService;

    @Autowired
    public MenuController(IMenuService menuService) {
        this.menuService = menuService;
    }

    @GetMapping("/list")
    public ResponseDTO handleMenuTree() {
        List<MenuEntity> list = menuService.allMenuList();
        return new ResponseDTO().setCode(200).setMessage("ok").setData(list);
    }


    // delete
    @DeleteMapping("")
    public ResponseDTO handleDeleteMenu(@RequestBody IdsForm ids) {
        boolean res = menuService.removeByIds(Arrays.asList(ids.getIds()));
        if (!res) {
            return new ResponseDTO().setCode(500).setMessage("删除失败");
        }
        return new ResponseDTO().setCode(200).setMessage("ok");
    }


    @PostMapping("")
    public ResponseDTO handleAddMenu(@RequestBody MenuEntity menuEntity) {
        boolean res = menuService.save(menuEntity);
        if (!res) {
            return new ResponseDTO().setCode(500).setMessage("保存成功");
        }
        return new ResponseDTO().setCode(200).setMessage("ok").setData(menuEntity.getId());
    }


    @PutMapping("")
    public ResponseDTO handleUpdateMenu(@RequestBody MenuEntity menuEntity) {
        log.info("menuEntity {}", menuEntity);
        boolean res = menuService.updateById(menuEntity);
        if (!res) {
            return new ResponseDTO().setCode(500).setMessage("更新失败");
        }
        return new ResponseDTO().setCode(200).setMessage("ok");
    }


    @GetMapping("/my/{ver}")
    public ResponseDTO handleMenuTree(@PathVariable("ver") String ver) {
        log.info("ver {}", ver);
        List<MenuEntity> list = menuService.getMenuListByRole("admin");
        HashMap<String, Object> data = new HashMap<>();
        data.put("dashboardGrid", Arrays.asList("welcome", "ver", "time", "progress", "echarts", "about"));
        data.put("permissions", Arrays.asList("list.add", "list.edit", "list.delete", "user.add", "user.edit", "user.delete"));
        data.put("menu", list);
        return new ResponseDTO().setCode(200).setMessage("ok").setData(data);
    }

}
