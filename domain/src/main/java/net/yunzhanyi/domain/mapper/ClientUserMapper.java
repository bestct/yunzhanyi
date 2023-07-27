package net.yunzhanyi.domain.mapper;

import net.yunzhanyi.domain.pojo.ClientUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
* @author bestct
* @description 针对表【client_user(用户表)】的数据库操作Mapper
* @createDate 2023-07-14 09:24:00
* @Entity net.yunzhanyi.domain.pojo.ClientUser
*/
@Mapper
public interface ClientUserMapper {

    int deleteByPrimaryKey(Long id);

    int insert(ClientUser record);

    int insertSelective(ClientUser record);

    ClientUser selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ClientUser record);

    int updateByPrimaryKey(ClientUser record);

    /**
     * 选择通过尼克名字
     *
     * @param nickName 尼克名字
     * @return {@link ClientUser}
     */
    ClientUser selectByNickName(@Param("nickName") String nickName);

    /**
     * 选择计数尼克名字
     *
     * @param nickName 尼克名字
     * @return long
     */
    long selectCountByNickName(@Param("nickName") String nickName);

}
