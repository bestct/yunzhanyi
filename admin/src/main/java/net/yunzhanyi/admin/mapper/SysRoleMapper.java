package net.yunzhanyi.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import net.yunzhanyi.admin.model.entity.SysRole;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Set;

@Mapper
public interface SysRoleMapper extends BaseMapper<SysRole> {


    /**
     * 获取最大范围的数据权限
     *
     * @param roles
     * @return
     */
    Integer getMaximumDataScope(@Param("roles") Set<String> roles);
}
