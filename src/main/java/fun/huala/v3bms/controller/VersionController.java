package fun.huala.v3bms.controller;


import fun.huala.v3bms.model.dto.ResponseDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersionController {

    @GetMapping("/ver")
    public ResponseDTO getVersion() {
        return new ResponseDTO().setData("1.0.0").setCode(200);
    }
}
