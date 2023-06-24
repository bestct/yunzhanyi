package net.yunzhanyi.client.service.impl;

import com.github.pagehelper.PageInfo;
import net.yunzhanyi.client.domain.dto.PoetryDto;
import net.yunzhanyi.client.domain.vo.PoetryVo;
import net.yunzhanyi.client.service.PoetryService;
import net.yunzhanyi.common.core.utils.StringUtils;
import net.yunzhanyi.common.core.vo.PageVo;
import net.yunzhanyi.domain.mapper.AuthorMapper;
import net.yunzhanyi.domain.mapper.DynastyMapper;
import net.yunzhanyi.domain.mapper.PoetryMapper;
import net.yunzhanyi.domain.mapper.TagMapper;
import net.yunzhanyi.domain.pojo.Author;
import net.yunzhanyi.domain.pojo.Dynasty;
import net.yunzhanyi.domain.pojo.Poetry;
import net.yunzhanyi.domain.pojo.Tag;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author bestct
 * @date 2023/5/8
 * description: TODO
 */
@Service
public class PoetryServiceImpl implements PoetryService {
    @Autowired
    private PoetryMapper poetryMapper;

    @Autowired
    private DynastyMapper dynastyMapper;

    @Autowired
    private TagMapper tagMapper;

    @Autowired
    private AuthorMapper authorMapper;

    /**
     * 被随机诗歌
     *
     * @return {@link Poetry}
     */
    @Override
    public Poetry getPoetryByRandom() {
        Integer count = poetryMapper.selectCount();
        Random rand = new Random();
        int offset = rand.nextInt(count ) + 1;
        return poetryMapper.selectRandomPoetry(offset);
    }

    /**
     * 随机搜索诗歌
     *
     * @param size 大小
     * @return {@link List}<{@link Poetry}>
     */
    @Override
    public List<Poetry> searchPoetryRandom(int size) {
        Integer count = poetryMapper.selectCount();
        Random rand = new Random();
        int pageNum = rand.nextInt(count / size) + 1;
        int offset = (pageNum - 1) * size;
        List<Poetry> poetries = poetryMapper.selectPoetrySimple(offset, size);
        return poetries;
    }

    /**
     * init王朝
     *
     * @return {@link List}<{@link Dynasty}>
     */
    @Override
    public List<Dynasty> initDynasty() {
        List<Dynasty> dynasties = dynastyMapper.selectInit();
        return dynasties;
    }

    @Override
    public List<Poetry> searchPoetry(String keyword) {
        return poetryMapper.selectByKeyword(keyword);
    }
    @Override
    public PageVo copyPageInfo(PageInfo<Poetry> poetryInfo) {
        List<Poetry> poetries = poetryInfo.getList();
        List<PoetryDto> poetryDtos = new ArrayList<>();
        if (poetries != null) {
            for (Poetry poetry : poetries) {
                PoetryDto poetryDto = new PoetryDto();
                BeanUtils.copyProperties(poetry, poetryDto);
                String tags = poetry.getTags();
                if (StringUtils.isNotEmpty(tags)) {
                    String[] split = tags.split(";");
                    List<Tag> tagList = new ArrayList<>();
                    for (String name : split) {
                        Tag tag = tagMapper.selectByName(name);
                        tagList.add(tag);
                    }
                    poetryDto.setTagList(tagList);
                }
                poetryDtos.add(poetryDto);
            }
        }
        PageVo poetryPageVo = new PageVo(poetryDtos);
        poetryPageVo.setPageNum(poetryInfo.getPageNum());
        poetryPageVo.setPages(poetryInfo.getPages());
        poetryPageVo.setNavigatepageNums(poetryInfo.getNavigatepageNums());
        poetryPageVo.setPageSize(poetryInfo.getPageSize());
        return poetryPageVo;
    }


    @Override
    public PoetryVo searchWebPoetryById(Long poetryId) {
        Poetry poetry = poetryMapper.selectWithDetailsByPrimaryKey(poetryId);
        if (poetry == null) {
            throw  new NullPointerException();
        }
        PoetryVo poetryVo = new PoetryVo();
        BeanUtils.copyProperties(poetry, poetryVo);
        String tags = poetry.getTags();
        if (StringUtils.isNotEmpty(tags)) {
            String[] split = tags.split(";");
            List<Tag> tagList = new ArrayList<>();
            for (String name : split) {
                Tag tag = tagMapper.selectByName(name);
                tagList.add(tag);
            }
            poetryVo.setTagList(tagList);
        }
      //  ClientLoginUser loginUser = AuthUtils.getLoginUser();
        long uid = -1;

        /*if (ObjectUtil.isNotEmpty(loginUser)) {
            uid = loginUser.getUid();
        }
        */
        //collectionService.isCollected(uid, poetryId, 1);
        poetryVo.setCollection(false);
        Author author = authorMapper.selectByPrimaryKey(poetry.getAuthorId());
        poetryVo.setAuthor(author);
        return poetryVo;
    }

    @Override
    public List<Poetry> getPoetryByAuthorId(Long authorId) {
        List<Poetry> poetries = poetryMapper.selectByAuthorId(authorId);
        return poetries;
    }

}
