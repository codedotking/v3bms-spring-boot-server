package fun.huala.v3bms.model.db;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("hl_file")
public class FileEntity {

    @TableId(type = IdType.AUTO)
    private Long id;

    String fileName;

    String path;

    String type;

    String suffix;

    Long size;

    String md5;
}
