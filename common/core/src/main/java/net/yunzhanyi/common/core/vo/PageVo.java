package net.yunzhanyi.common.core.vo;

import lombok.*;

import java.util.List;

/**
 * @author bestct
 * @date 2023/5/24
 * description: TODO
 */

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
public class PageVo {
    private List<?> list;
    private int pages;
    private int pageNum;
    private int pageSize;
    private int[] navigatepageNums;
    public PageVo(List<?> list) {
        this.list = list;
    }
}
