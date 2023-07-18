package net.yunzhanyi.client.service.impl;

import com.github.pagehelper.PageHelper;
import net.yunzhanyi.client.domain.dto.CollectionDto;
import net.yunzhanyi.client.service.CollectionService;
import net.yunzhanyi.domain.mapper.AuthorMapper;
import net.yunzhanyi.domain.mapper.ClientCollectionMapper;
import net.yunzhanyi.domain.mapper.PoetryMapper;
import net.yunzhanyi.domain.pojo.ClientCollection;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author bestct
 * @date 2023/7/18
 * description:
 */
@Service
public class CollectionServiceImpl implements CollectionService {

    @Autowired
    private ClientCollectionMapper collectionMapper;

    @Autowired
    private PoetryMapper poetryMapper;

    @Autowired
    private AuthorMapper authorMapper;

    @Override
    public List<CollectionDto> getUserApiCollection(Long userid, Integer collectionType, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<CollectionDto> collectionDtos = new ArrayList<>();
        List<ClientCollection> collectionList = collectionMapper.selectByUserid(userid, collectionType);
        for (ClientCollection collection : collectionList) {
            String name = null;
            if (collection.getCollectionType() == 1) {
                name = poetryMapper.selectTitleById(collection.getResId());
            } else if (collection.getCollectionType() == 2) {
                name = authorMapper.selectAuthorNameById(collection.getResId());
            }
            CollectionDto collectionDto = new CollectionDto();
            BeanUtils.copyProperties(collection, collectionDto);
            collectionDto.setResName(name);
            collectionDtos.add(collectionDto);
        }
        return collectionDtos;
    }

    @Override
    public void addCollection(Long resId, Long userid, Integer collectionType) {
        ClientCollection collection = collectionMapper.selectByResIdAndUid(userid, resId, collectionType);
        if (collection == null) {
            collection = new ClientCollection();
            collection.setCollectionTime(new Date());
            collection.setUserId(userid);
            collection.setResId(resId);
            collection.setCollectionType(collectionType);
            collection.setCollectionStatus(1);
            collectionMapper.insertSelective(collection);
        } else {
            if (collection.getCollectionStatus() == 1) {
                throw new RuntimeException("收藏失败,原因:已收藏");
            } else {
                collection.setCollectionStatus(1);
                collection.setCollectionTime(new Date());
                collectionMapper.updateByPrimaryKeySelective(collection);
            }
        }
    }

    /**
     * 取消收藏id
     *
     * @param colId 坳id
     */
    @Override
    public void cancelCollectionById(Long colId) {
        collectionMapper.updateStatusByPrimaryKey(colId, 0);
    }

    /**
     * 再通过id集合
     *
     * @param colId 坳id
     */
    @Override
    public void reCollectionById(Long colId) {
        collectionMapper.updateStatusByPrimaryKey(colId, 1);
    }

    @Override
    public void cancelCollection(Long resId, Long userid, Integer collectionType) {
        ClientCollection collection = collectionMapper.selectByResIdAndUid(userid, resId, collectionType);
        if (collection == null) {
            throw new RuntimeException("未收藏");
        } else {
            if (collection.getCollectionStatus() == 0) {
                throw new RuntimeException("未收藏");
            } else {
                collection.setCollectionStatus(0);
                collectionMapper.updateByPrimaryKeySelective(collection);
            }
        }
    }

    @Override
    public Boolean isCollected(long uid, Long poetryId, Integer collectionType) {
        if (uid == -1) {
            return false;
        }
        ClientCollection collection = collectionMapper.selectByResIdAndUid(uid, poetryId, collectionType);
        if (collection == null) {
            return false;
        }
        return collection.getCollectionStatus() == 1;
    }

}
