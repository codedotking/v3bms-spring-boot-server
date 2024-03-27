package fun.huala.v3bms.model.dto;


import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class ResponseDTO {

    private Integer code;

    private String message;

    private Object data;
}
