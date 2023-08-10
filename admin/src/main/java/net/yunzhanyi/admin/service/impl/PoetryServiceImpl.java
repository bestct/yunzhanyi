package net.yunzhanyi.admin.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.RequiredArgsConstructor;
import net.yunzhanyi.admin.model.query.PoetryPageQuery;
import net.yunzhanyi.admin.service.PoetryService;
import net.yunzhanyi.domain.mapper.PoetryMapper;
import net.yunzhanyi.domain.pojo.Poetry;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author bestct
 * @date 2023/7/31
 * description:
 */
@Service
@RequiredArgsConstructor
public class PoetryServiceImpl implements PoetryService {

    private final PoetryMapper poetryMapper;

    @Override
    public PageInfo<Poetry> listPoetry(PoetryPageQuery queryParams) {
        PageHelper.startPage(queryParams.getPageNum(), queryParams.getPageSize());
        Poetry poetry = new Poetry();
        BeanUtils.copyProperties(queryParams,poetry);
        List<Poetry> poetryList = poetryMapper.selectList(poetry);
        return new PageInfo<>(poetryList);
    }

    @Override
    public Poetry getPoetryForm(Long id) {
        return poetryMapper.selectByPrimaryKey(id);
    }

    @Override
    public boolean updatePoetry(Long id, Poetry poetry) {
        return false;
    }

    @Override
    public boolean savePoetry(Poetry poetry) {
        return false;
    }

    @Override
    public boolean deletePoetry(String ids) {
        return false;
    }
}
