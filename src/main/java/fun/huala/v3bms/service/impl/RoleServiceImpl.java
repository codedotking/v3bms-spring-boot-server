package fun.huala.v3bms.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import fun.huala.v3bms.mapper.RoleMapper;
import fun.huala.v3bms.model.db.RoleEntity;
import fun.huala.v3bms.service.IRoleService;
import org.springframework.stereotype.Service;


@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, RoleEntity> implements IRoleService {
}
