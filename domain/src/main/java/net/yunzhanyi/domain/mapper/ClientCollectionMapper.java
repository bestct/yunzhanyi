package net.yunzhanyi.domain.mapper;

import net.yunzhanyi.domain.pojo.ClientCollection;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author bestct
* @description 针对表【client_collection】的数据库操作Mapper
* @createDate 2023-07-18 13:24:43
* @Entity net.yunzhanyi.domain.pojo.ClientCollection
*/
@Mapper
public interface ClientCollectionMapper {

    int deleteByPrimaryKey(Long id);

    int insert(ClientCollection record);

    int insertSelective(ClientCollection record);

    ClientCollection selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ClientCollection record);

    int updateByPrimaryKey(ClientCollection record);

    /**
     * 选择用户标识
     *
     * @param userid         用户标识
     * @param collectionType 集合类型
     * @return {@link List}<{@link ClientCollection}>
     */
    List<ClientCollection> selectByUserid(@Param("userid") Long userid, @Param("collectionType") Integer collectionType);

    /**
     * 选择通过res id和uid
     *
     * @param userid         用户标识
     * @param resId          res id
     * @param collectionType 集合类型
     * @return {@link ClientCollection}
     */
    ClientCollection selectByResIdAndUid(@Param("userid") Long userid, @Param("resId") Long resId, @Param("collectionType") Integer collectionType);

    /**
     * 由主键更新状态
     *
     * @param colId            坳id
     * @param collectionStatus 收集状态
     */
    void updateStatusByPrimaryKey(@Param("colId") Long colId, @Param("collectionStatus") Integer collectionStatus);
}
