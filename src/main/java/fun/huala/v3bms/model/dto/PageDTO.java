package fun.huala.v3bms.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class PageDTO<T> {

    private Long total;
    private Long pages;
    private List<T> rows;
}
