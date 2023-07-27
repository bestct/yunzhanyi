package net.yunzhanyi.domain.mapper;

import net.yunzhanyi.domain.pojo.ClientAccount;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
* @author bestct
* @description 针对表【client_account(账号表)】的数据库操作Mapper
* @createDate 2023-07-14 09:28:40
* @Entity net.yunzhanyi.domain.pojo.ClientAccount
*/
@Mapper
public interface ClientAccountMapper {

    int deleteByPrimaryKey(Long id);

    int insert(ClientAccount record);

    int insertSelective(ClientAccount record);

    ClientAccount selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ClientAccount record);

    int updateByPrimaryKey(ClientAccount record);

    ClientAccount selectByPhone(@Param("phone") String phone);

    ClientAccount selectByEmail(@Param("email") String email);

    ClientAccount selectByOpenid(@Param("openid") String openid);
}
