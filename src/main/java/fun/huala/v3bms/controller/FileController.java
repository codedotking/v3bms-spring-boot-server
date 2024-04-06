package fun.huala.v3bms.controller;


import fun.huala.v3bms.model.db.FileEntity;
import fun.huala.v3bms.model.dto.ResponseDTO;
import fun.huala.v3bms.service.IFileService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Objects;


@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/sys/file")
public class FileController {

    private final IFileService fileService;


    @PostMapping("")
    public ResponseDTO handleUpload(@RequestParam("file") MultipartFile file) {
        if(file.isEmpty()){
            return new ResponseDTO().setCode(400).setMessage("上传文件不能为空");
        }
        FileEntity fileEntity = fileService.storeFile(file);
        return new ResponseDTO().setCode(200).setData(fileEntity).setMessage("上传成功");
    }

}
