package net.yunzhanyi.domain.mapper;

import net.yunzhanyi.domain.pojo.ClientUser;
import org.apache.ibatis.annotations.Mapper;

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

}
