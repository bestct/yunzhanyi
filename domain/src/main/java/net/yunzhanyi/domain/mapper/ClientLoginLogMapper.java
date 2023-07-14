package net.yunzhanyi.domain.mapper;

import net.yunzhanyi.domain.pojo.ClientLoginLog;
import org.apache.ibatis.annotations.Mapper;

/**
* @author bestct
* @description 针对表【client_login_log】的数据库操作Mapper
* @createDate 2023-07-14 09:30:23
* @Entity net.yunzhanyi.domain.pojo.ClientLoginLog
*/
@Mapper
public interface ClientLoginLogMapper {

    int deleteByPrimaryKey(Long id);

    int insert(ClientLoginLog record);

    int insertSelective(ClientLoginLog record);

    ClientLoginLog selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ClientLoginLog record);

    int updateByPrimaryKey(ClientLoginLog record);

}
