package fun.huala.v3bms.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import fun.huala.v3bms.mapper.DeptMapper;
import fun.huala.v3bms.model.db.DeptEntity;
import fun.huala.v3bms.service.IDeptService;
import org.springframework.stereotype.Service;

@Service
public class DeptServiceImpl extends ServiceImpl<DeptMapper, DeptEntity> implements IDeptService {
}
