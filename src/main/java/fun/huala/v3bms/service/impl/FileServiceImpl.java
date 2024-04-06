package fun.huala.v3bms.service.impl;

import fun.huala.v3bms.model.db.FileEntity;
import fun.huala.v3bms.service.IFileService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;
import java.util.UUID;


@Service
public class FileServiceImpl implements IFileService {



    @Value("${web.upload-path}")
    private String uploadPath;
    @Value("${web.access-prefix}")
    private String accessPrefix;

    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd/");

    @Override
    public FileEntity storeFile(MultipartFile file) {
        String format = sdf.format(new Date());
        File folder = new File(String.format("%s/%s", uploadPath, format));
        if (!folder.isDirectory()) {
            folder.mkdirs();
        }
        String oldName = file.getOriginalFilename();
        oldName = Objects.isNull(oldName) ? "" : oldName;
        String newName = UUID.randomUUID()
                + oldName.substring(oldName.lastIndexOf("."), oldName.length());
        try {
            // 文件保存
            file.transferTo(new File(folder, newName));
            FileEntity fileEntity = new FileEntity();
            @SuppressWarnings("null")
            String path = ServletUriComponentsBuilder.fromCurrentContextPath()
                    .path(String.format("/%s/%s%s", accessPrefix, format, newName))
                    .toUriString();
            fileEntity.setPath(path);
            fileEntity.setFileName(newName);
            return fileEntity;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
