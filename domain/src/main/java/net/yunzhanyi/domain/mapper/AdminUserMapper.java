package net.yunzhanyi.domain.mapper;

import net.yunzhanyi.domain.pojo.AdminUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
* @author bestct
* @description 针对表【admin_user】的数据库操作Mapper
* @createDate 2023-04-20 23:26:52
* @Entity net.yunzhanyi.domain.pojo.AdminUser
*/

@Mapper
public interface AdminUserMapper {

    /**
     * 按主键删除
     *
     * @param id id
     * @return int
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 插入
     *
     * @param record 记录
     * @return int
     */
    int insert(AdminUser record);

    /**
     * 插入选择性
     *
     * @param record 记录
     * @return int
     */
    int insertSelective(AdminUser record);

    /**
     * 选择通过主键
     *
     * @param id id
     * @return {@link AdminUser}
     */
    AdminUser selectByPrimaryKey(Integer id);

    /**
     * 更新主键选择性
     *
     * @param record 记录
     * @return int
     */
    int updateByPrimaryKeySelective(AdminUser record);

    /**
     * 更新主键
     *
     * @param record 记录
     * @return int
     */
    int updateByPrimaryKey(AdminUser record);

    /**
     * 选择用户名
     *
     * @param username 用户名
     * @return {@link AdminUser}
     */
    AdminUser selectByUsername(@Param("username") String username);

}
