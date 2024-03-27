package fun.huala.v3bms.model.db;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("hl_staff")
public class StaffEntity {

    @TableId(type = IdType.AUTO)
    private Long id;

    private String email;

    private String phone;

    private String nick;

    private String name;

    private String account;

    private String password;

}
