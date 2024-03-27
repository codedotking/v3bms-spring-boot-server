package fun.huala.v3bms.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import fun.huala.v3bms.mapper.StaffMapper;
import fun.huala.v3bms.model.db.StaffEntity;
import fun.huala.v3bms.service.IStaffService;
import org.springframework.stereotype.Service;

@Service
public class StaffServiceImpl extends ServiceImpl<StaffMapper, StaffEntity> implements IStaffService {
}
