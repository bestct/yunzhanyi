package net.yunzhanyi.admin.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import net.yunzhanyi.admin.dto.AuthorityDto;
import net.yunzhanyi.admin.mapper.AuthorityMapper;
import net.yunzhanyi.admin.mapper.RoleMapper;
import net.yunzhanyi.admin.service.RoleService;
import net.yunzhanyi.common.model.Authority;
import net.yunzhanyi.common.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author TingChang
 * @code RoleServiceImpl
 * @date 2021/5/11
 * description:
 */

@Service
public class RoleServiceImpl implements RoleService {


    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private AuthorityMapper authorityMapper;

    @Override
    public PageInfo<Role> getRolePageInfo(Integer pageNum, Integer pageSize, String searchVal) {
        PageHelper.startPage(pageNum,pageSize);
        List<Role> roles= roleMapper.selectBySearch(searchVal);
        return new PageInfo<>(roles);
    }

    @Override
    public void addRole(Role role) {
        roleMapper.insertSelective(role);
    }

    @Override
    public void editRole(Role role) {
        roleMapper.updateByPrimaryKeySelective(role);
    }

    @Override
    public void deleteRole(List<Integer> roleIds) {
        roleMapper.deleteByRoleIds(roleIds);
        roleMapper.deleteAdminRelationshipByRoleIds(roleIds);
        roleMapper.deleteAuthRelationshipByRoleIds(roleIds);
    }

    @Override
    public AuthorityDto getRoleAuth(String rid) {
        List<Integer> authIdByRid=roleMapper.selectByAuthIdByRid(rid);
        List<Authority>authorities=authorityMapper.selectByAll();

        return new AuthorityDto(authorities,authIdByRid);
    }

    @Override
    public void addRoleRelationship(List<Integer> aids, Integer rid) {
        roleMapper.deleteRelationshipByRid(rid);
        roleMapper.insertRoleRelationship(aids,rid);
    }
}
