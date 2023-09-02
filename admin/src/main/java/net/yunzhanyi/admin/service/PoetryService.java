package net.yunzhanyi.admin.service;

import com.github.pagehelper.PageInfo;
import net.yunzhanyi.admin.model.query.PoetryPageQuery;
import net.yunzhanyi.domain.pojo.Poetry;

/**
 * 诗歌服务
 *
 * @author bestct
 * @date 2023/07/31
 */
public interface PoetryService {

    /**
     * 清单诗
     *
     * @param queryParams 查询参数
     * @return {@link PageInfo}<{@link Poetry}>
     */
    PageInfo<Poetry> listPoetry(PoetryPageQuery queryParams);

    /**
     * 把诗歌形式
     *
     * @param id id
     * @return {@link Poetry}
     */
    Poetry getPoetryForm(Long id);

    /**
     * 更新诗歌
     *
     * @param id     id
     * @param poetry 诗歌
     * @return boolean
     */
    boolean updatePoetry(Long id, Poetry poetry);

    boolean savePoetry(Poetry poetry);

    boolean deletePoetry(String ids);
}
