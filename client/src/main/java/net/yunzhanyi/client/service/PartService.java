package net.yunzhanyi.client.service;

import net.yunzhanyi.domain.pojo.Part;

import java.util.List;

/**
 * @author bestct
 * @date 2023/5/8
 * description: TODO
 */
public interface PartService {
    /**
     * 随机搜索部分
     *
     * @param i 我
     * @return {@link List}<{@link Part}>
     */
    List<Part> searchPartRandom(int i);
}
