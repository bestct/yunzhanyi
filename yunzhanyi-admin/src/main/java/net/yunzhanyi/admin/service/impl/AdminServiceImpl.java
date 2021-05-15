package net.yunzhanyi.admin.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import net.yunzhanyi.admin.dto.RoleDto;
import net.yunzhanyi.admin.exception.ChangePasswordException;
import net.yunzhanyi.admin.mapper.AdminMapper;
import net.yunzhanyi.admin.mapper.RoleMapper;
import net.yunzhanyi.admin.service.AdminService;
import net.yunzhanyi.common.model.Admin;
import net.yunzhanyi.common.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author TingChang
 * @code AdminServiceImpl
 * @date 2021/4/26
 * description:
 */
@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminMapper adminMapper;

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Override
    public void addAdmin(Admin admin) {
        String encodePassword = passwordEncoder.encode(admin.getPassword());
        admin.setAccountNonExpired(true);
        admin.setCredentialsNonExpired(true);
        admin.setAccountNonLocked(true);
        admin.setEnabled(true);
        admin.setPassword(encodePassword);
        adminMapper.insert(admin);
    }

    @Override
    public PageInfo<Admin> getAdminPageInfo(Integer pageNum, Integer pageSize, String searchVal) {
        PageHelper.startPage(pageNum, pageSize);
        List<Admin> admins = adminMapper.selectBySearchVal(searchVal);
        return new PageInfo<>(admins);
    }

    @Override
    public void removeAdmin(List<Integer> adminIds) {
        adminMapper.deleteByAdminIds(adminIds);
        adminMapper.deleteRelationshipByAdminIds(adminIds);
    }

    @Override
    public Admin getAdminByAid(Integer aid) {

        Admin admin = adminMapper.selectByAid(aid);

        return admin;
    }

    @Override
    public void editAdmin(Admin admin) {

        adminMapper.updateByPrimaryKeySelective(admin);
    }

    @Override
    public RoleDto getAdminRole(String aid) {
        List<Integer> roleIdByAid=adminMapper.selectByRoleIdByAid(aid);
        List<Role>roles=roleMapper.selectByAll();
        return new RoleDto(roles,roleIdByAid);
    }

    @Override
    public void addAdminRelationship(List<Integer> rids, Integer aid) {
        adminMapper.deleteRelationshipByAid(aid);
        adminMapper.insertRoleRelationship(rids,aid);
    }

    @Override
    public void changePasswordByUserName(String oldPassword, String newPassword, String username) {
        Admin admin = adminMapper.selectByAdminId(username);
        if (!passwordEncoder.matches(oldPassword,admin.getPassword())) {
            throw new ChangePasswordException();
        } else {
            String encodeNewPassword = passwordEncoder.encode(newPassword);
            admin.setPassword(encodeNewPassword);
            adminMapper.updatePasswordByPrimaryKey(admin);
        }
    }
}
