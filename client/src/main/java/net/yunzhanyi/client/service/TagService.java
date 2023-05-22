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

}
