package fun.huala.v3bms.model.db;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

@Data
@TableName("hl_menu_meta")
public class MenuMetaEntity {
    @TableId(type = IdType.AUTO)
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;

    @JsonSerialize(using = ToStringSerializer.class)
    private Long menuId;

    private String title;
    private boolean hidden;
    private boolean affix;
    private String icon;
    private String type;
    private boolean hiddenBreadcrumb;
    private String active;
    private String color;
    private boolean fullPage;
    private String role;
    private String tag;
}
