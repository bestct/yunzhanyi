package net.yunzhanyi.admin.service;

import com.github.pagehelper.PageInfo;
import net.yunzhanyi.common.model.Writing;

import java.util.List;

/**
 * @author TingChang
 * @name WritingService
 * @date 2021/4/30
 * description:
 */

public interface WritingService {
    PageInfo<Writing> loadWritingPageInfo(Integer pageNum, Integer pageSize, String searchVal, String type,String dynasty);

    void addWriting(Writing writing);

    Writing getWritingOne(Integer id);

    void remove(List<Integer> writingIds);

    void changeWriting(Writing writing);

    List<Integer> getWritingsById(Integer id);
}
