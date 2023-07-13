package net.yunzhanyi.client.service;

import net.yunzhanyi.domain.pojo.Tag;

import java.util.List;

/**
 * 标签服务
 *
 * @author bestct
 * @date 2023/05/22
 */
public interface TagService {
    /**
     * init标记
     *
     * @return {@link List}<{@link Tag}>
     */
    List<Tag> initTag();

    /**
     * 检查标签id
     *
     * @param tagId  标签id
     * @param tagVos 标签vos
     * @return {@link List}<{@link Tag}>
     */
    List<Tag> checkTagId(Integer tagId, List<Tag> tagVos);
}
