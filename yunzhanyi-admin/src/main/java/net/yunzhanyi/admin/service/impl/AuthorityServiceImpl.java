package net.yunzhanyi.admin.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import net.yunzhanyi.admin.mapper.AuthorityMapper;
import net.yunzhanyi.admin.service.AuthorityService;
import net.yunzhanyi.common.model.Authority;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author TingChang
 * @code AuthorityServiceImpl
 * @date 2021/5/9
 * description:
 */

@Service
public class AuthorityServiceImpl implements AuthorityService {

    @Autowired
    private AuthorityMapper authorityMapper;


    @Override
    public PageInfo<Authority> loadAuthorityPageInfo(Integer pageNum, Integer pageSize, String searchVal) {

        PageHelper.startPage(pageNum,pageSize);
        List<Authority> authorities=authorityMapper.selectBySearchVal(searchVal);
        return new PageInfo<>(authorities);
    }

    @Override
    public void addAuthority(Authority authority) {
        authorityMapper.insertSelective(authority);
    }

    @Override
    public void editAuthority(Authority authority) {
        authorityMapper.updateByPrimaryKeySelective(authority);
    }

    @Override
    public void removeAuthority(List<Integer> authorityIds) {
        authorityMapper.deleteByAuthorityIds(authorityIds);
        authorityMapper.deleteRelationshipByAuthorityIds(authorityIds);
    }
}
