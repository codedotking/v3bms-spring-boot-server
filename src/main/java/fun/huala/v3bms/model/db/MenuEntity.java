package fun.huala.v3bms.model.db;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.List;

@Data
@TableName("hl_menu")
public class MenuEntity {

    @TableId(type = IdType.AUTO)
    private Long id;

    private String name;

    private String path;

    private String redirect;

    private Long parentId;

    private Long sort;

    private String component;

    private boolean disabled;

    @TableField(exist = false)
    private MenuMetaEntity meta;

    @TableField(exist = false)
    private List<MenuEntity> children;
}
