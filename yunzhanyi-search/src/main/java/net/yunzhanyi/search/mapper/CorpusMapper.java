package net.yunzhanyi.search.mapper;

import net.yunzhanyi.common.model.Corpus;
import net.yunzhanyi.common.model.CorpusExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
/**
 * @author TingChang
 */
@Mapper
public interface CorpusMapper {
    long countByExample(CorpusExample example);

    int deleteByExample(CorpusExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Corpus record);

    int insertSelective(Corpus record);

    List<Corpus> selectByExample(CorpusExample example);

    Corpus selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Corpus record, @Param("example") CorpusExample example);

    int updateByExample(@Param("record") Corpus record, @Param("example") CorpusExample example);

    int updateByPrimaryKeySelective(Corpus record);

    int updateByPrimaryKey(Corpus record);
}