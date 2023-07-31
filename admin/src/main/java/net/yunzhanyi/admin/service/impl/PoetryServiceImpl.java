package net.yunzhanyi.admin.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.RequiredArgsConstructor;
import net.yunzhanyi.admin.model.query.PoetryPageQuery;
import net.yunzhanyi.admin.service.PoetryService;
import net.yunzhanyi.domain.mapper.PoetryMapper;
import net.yunzhanyi.domain.pojo.Poetry;
import org.springframework.stereotype.Service;

/**
 * @author bestct
 * @date 2023/7/31
 * description:
 */
@Service
@RequiredArgsConstructor
public class PoetryServiceImpl implements PoetryService {
    private final PoetryMapper poetryMapper;

    /**
     * 让诗歌页面
     *
     * @param queryParams 查询参数
     * @return {@link Page}<{@link Poetry}>
     */
    @Override
    public Page<Poetry> getPoetryPage(PoetryPageQuery queryParams) {
        return null;
    }
}
