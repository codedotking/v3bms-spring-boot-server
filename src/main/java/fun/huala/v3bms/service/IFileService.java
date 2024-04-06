package fun.huala.v3bms.service;

import fun.huala.v3bms.model.db.FileEntity;
import org.springframework.web.multipart.MultipartFile;

/**
 * 文件存储服务
 *
 */
public interface IFileService {

    FileEntity storeFile(MultipartFile file);
}
