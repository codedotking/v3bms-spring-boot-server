package fun.huala.v3bms.model.db;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@TableName("hl_dept")
public class DeptEntity {

    @TableId(type = IdType.AUTO)
    private Long id;

    private String name;

    private String description;

    private Long parentId;

    private Integer status;

    private Integer sort;

    private Integer deleted;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;
}
