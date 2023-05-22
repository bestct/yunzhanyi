package net.yunzhanyi.client.service;

import net.yunzhanyi.domain.pojo.Dynasty;
import net.yunzhanyi.domain.pojo.Poetry;

import java.util.List;

/**
 * @author bestct
 * @date 2023/5/8
 * description: TODO
 */

public interface PoetryService {
    /**
     * 被随机诗歌
     *
     * @return {@link Poetry}
     */
    Poetry getPoetryByRandom();

    List<Poetry> searchPoetryRandom(int i);

    List<Dynasty> initDynasty();
}
