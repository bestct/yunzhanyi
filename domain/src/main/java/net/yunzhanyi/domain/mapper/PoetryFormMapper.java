package net.yunzhanyi.domain.mapper;

import net.yunzhanyi.domain.pojo.PoetryForm;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
* @author bestct
* @description 针对表【poetry_form】的数据库操作Mapper
* @createDate 2023-05-09 13:20:45
* @Entity net.yunzhanyi.domain.pojo.PoetryForm
*/
@Mapper
public interface PoetryFormMapper {

    int deleteByPrimaryKey(Long id);

    int insert(PoetryForm record);

    int insertSelective(PoetryForm record);

    PoetryForm selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(PoetryForm record);

    int updateByPrimaryKey(PoetryForm record);

    /**
     * 选择类型
     *
     * @param formType  表单类型
     * @param firstType 第一个类型
     * @return {@link PoetryForm}
     */
    PoetryForm selectByType(@Param("formType") Integer formType, @Param("firstType") Integer firstType);
}
