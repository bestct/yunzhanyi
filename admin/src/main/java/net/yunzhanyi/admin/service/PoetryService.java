package net.yunzhanyi.admin.service;

import net.yunzhanyi.domain.pojo.Dynasty;
import net.yunzhanyi.domain.pojo.Poetry;
import net.yunzhanyi.domain.pojo.Tag;

import java.util.List;

/**
 * @author bestct
 * @date 2023/5/5
 * description: TODO
 */
public interface PoetryService {

    /**
     * 得到列表
     *
     * @param poetry 诗歌
     * @return {@link List}<{@link Poetry}>
     */

    List<Poetry> getList(Poetry poetry);

    /**
     * init标记
     *
     * @return {@link List}<{@link Tag}>
     */
    List<Tag> initTag();

    /**
     * init王朝
     *
     * @return {@link List}<{@link Dynasty}>
     */
    List<Dynasty> initDynasty();

}
