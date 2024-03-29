package fun.huala.v3bms.model.db;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;


@Data
@TableName("hl_role")
public class RoleEntity {

    @TableId(type = IdType.AUTO)
    private Long id;

    private String name;

    private String code;

    private Integer sort;

    private Byte status;

    @TableLogic
    private boolean deleted;

    private String description;
}
