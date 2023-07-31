package net.yunzhanyi.admin.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import net.yunzhanyi.admin.model.query.PoetryPageQuery;
import net.yunzhanyi.domain.pojo.Poetry;

/**
 * 诗歌服务
 *
 * @author bestct
 * @date 2023/07/31
 */
public interface PoetryService {
    /**
     * 让诗歌页面
     *
     * @param queryParams 查询参数
     * @return {@link Page}<{@link Poetry}>
     */
    Page<Poetry> getPoetryPage(PoetryPageQuery queryParams);
}
