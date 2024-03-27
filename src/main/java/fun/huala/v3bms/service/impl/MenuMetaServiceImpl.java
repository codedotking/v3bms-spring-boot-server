package fun.huala.v3bms.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import fun.huala.v3bms.mapper.MenuMetaMapper;
import fun.huala.v3bms.model.db.MenuMetaEntity;
import fun.huala.v3bms.service.IMenuMetaService;
import org.springframework.stereotype.Service;


@Service
public class MenuMetaServiceImpl extends ServiceImpl<MenuMetaMapper, MenuMetaEntity> implements IMenuMetaService {
}
