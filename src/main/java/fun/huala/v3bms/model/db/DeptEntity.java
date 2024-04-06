package fun.huala.v3bms.model.db;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@TableName("hl_dept")
public class DeptEntity {

    @TableId(type = IdType.AUTO)
    private Long id;

    private String name;

    private String remark;

    private Long parentId;

    private Integer status;

    private Integer sort;

    private Integer deleted;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

    @TableField(exist = false)
    private List<DeptEntity> children;
}
