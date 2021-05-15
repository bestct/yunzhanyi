package net.yunzhanyi.admin.config.security;

import net.yunzhanyi.admin.exception.LoginException;
import net.yunzhanyi.admin.mapper.AdminMapper;
import net.yunzhanyi.admin.mapper.AuthorityMapper;
import net.yunzhanyi.admin.mapper.RoleMapper;
import net.yunzhanyi.common.model.Admin;
import net.yunzhanyi.common.model.Authority;
import net.yunzhanyi.common.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author TingChang
 * @code UserDetailsServiceImpl
 * @date 2021/4/30
 * description:
 */
@Service("myUserDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {


    @Autowired
    private AdminMapper adminMapper;

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private AuthorityMapper authorityMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Admin admin = adminMapper.selectByAdminId(username);
        if (admin == null) {
            throw new LoginException("用户名或密码错误");
        }
        List<GrantedAuthority> authorities = new ArrayList<>();
        List<Role> roles = roleMapper.selectByAid(admin.getId());
        for (Role role:roles) {
            authorities.add(new SimpleGrantedAuthority("ROLE_"+role.getName()));
            System.out.println(role);
            List<Authority> auths=authorityMapper.selectByRid(role.getId());
            if (auths==null||auths.size()==0){
                continue;
            }
            for (Authority authority:auths){
                authorities.add(new SimpleGrantedAuthority(authority.getPower()));
            }
        }

        return new User(admin.getAdminId(), admin.getPassword(), admin.getEnabled(), admin.getAccountNonExpired(), admin.getCredentialsNonExpired(), admin.getAccountNonLocked(), authorities);
    }
}
