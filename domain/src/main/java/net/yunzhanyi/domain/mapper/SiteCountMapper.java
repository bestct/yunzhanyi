package net.yunzhanyi.domain.mapper;

import net.yunzhanyi.domain.domain.SiteCount;
import org.apache.ibatis.annotations.Mapper;

/**
* @author bestct
* @description 针对表【site_count】的数据库操作Mapper
* @createDate 2023-09-03 15:28:42
* @Entity net.yunzhanyi.domain.domain.SiteCount
*/
@Mapper
public interface SiteCountMapper {

    int deleteByPrimaryKey(Long id);

    int insert(SiteCount record);

    int insertSelective(SiteCount record);

    SiteCount selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SiteCount record);

    int updateByPrimaryKey(SiteCount record);

}
