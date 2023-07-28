package net.yunzhanyi.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import net.yunzhanyi.admin.common.annotation.DataPermission;
import net.yunzhanyi.admin.model.bo.UserBO;
import net.yunzhanyi.admin.model.bo.UserFormBO;
import net.yunzhanyi.admin.model.dto.UserAuthInfo;
import net.yunzhanyi.admin.model.entity.SysUser;
import net.yunzhanyi.admin.model.query.UserPageQuery;
import net.yunzhanyi.admin.model.vo.UserExportVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 用户持久层
 *
 * @author haoxr
 * @since 2022/1/14
 */
@Mapper
public interface SysUserMapper extends BaseMapper<SysUser> {

    /**
     * 获取用户分页列表
     *
     * @param page
     * @param queryParams 查询参数
     * @return
     */
    @DataPermission(deptAlias = "u")
    Page<UserBO> getUserPage(@Param("page") Page<UserBO> page, @Param("queryParams") UserPageQuery queryParams);

    /**
     * 获取用户表单详情
     *
     * @param userId 用户ID
     * @return
     */
    UserFormBO getUserDetail(Long userId);

    /**
     * 根据用户名获取认证信息
     *
     * @param username
     * @return
     */
    UserAuthInfo getUserAuthInfo(String username);

    /**
     * 获取导出用户列表
     *
     * @param queryParams
     * @return
     */
    @DataPermission(deptAlias = "u")
    List<UserExportVO> listExportUsers(UserPageQuery queryParams);
}
