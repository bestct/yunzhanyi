package net.yunzhanyi.admin.mapper;

/**
 * 菜单持久接口层
 *
 * @author haoxr
 * @since 2022/1/24
 */

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import net.yunzhanyi.admin.model.bo.RouteBO;
import net.yunzhanyi.admin.model.entity.SysMenu;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Set;

@Mapper
public interface SysMenuMapper extends BaseMapper<SysMenu> {

    List<RouteBO> listRoutes();

    /**
     * 获取角色权限集合
     *
     * @param roles
     * @return
     */
    Set<String> listRolePerms(@Param("roles") Set<String> roles);
}
