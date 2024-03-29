package fun.huala.v3bms.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import fun.huala.v3bms.model.dto.PageDTO;
import fun.huala.v3bms.model.vo.PageQuery;


public interface BaseService<T> extends IService<T> {
    default PageDTO<T> list(PageQuery query) {
        IPage<T> page = Page.of(query.getPage(), query.getPageSize());
        this.page(page);
        return new PageDTO<>(page.getTotal(), page.getPages(), page.getRecords());
    }
}
