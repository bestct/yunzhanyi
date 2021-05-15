package net.yunzhanyi.admin.service;

import com.github.pagehelper.PageInfo;
import net.yunzhanyi.common.model.Authority;

import java.util.List;

/**
 * @author TingChang
 * @code AuthorityService
 * @date 2021/5/9
 * description:
 */

public interface AuthorityService {
    PageInfo<Authority> loadAuthorityPageInfo(Integer pageNum, Integer pageSize, String searchVal);

    void addAuthority(Authority authority);

    void editAuthority(Authority authority);

    void removeAuthority(List<Integer> authorityIds);

}
