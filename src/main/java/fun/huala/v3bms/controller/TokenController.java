package fun.huala.v3bms.controller;


import fun.huala.v3bms.model.dto.ResponseDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.HashMap;
import java.util.UUID;

@RestController
@RequestMapping("/token")
public class TokenController {


    @PostMapping("")
    public ResponseDTO handleToken() {
        HashMap<String, Object> data = new HashMap<>();
        data.put("token", UUID.randomUUID().toString());
        HashMap<String, Object> userInfo = new HashMap<>();
        userInfo.put("dashboard", 0);
        userInfo.put("role", Arrays.asList("SA", "admin", "Auditor"));
        userInfo.put("userId", 0);
        userInfo.put("userName", "userName");
        data.put("userInfo", userInfo);
        return new ResponseDTO().setCode(200).setMessage("ok").setData(data);
    }


}
