package net.yunzhanyi.admin.dto;

import net.yunzhanyi.common.model.Authority;

import java.util.List;

/**
 * @author TingChang
 * @code AuthorityDto
 * @date 2021/4/25
 * description:
 */

public class AuthorityDto {
    List<Authority> allAuthority;
    List<Integer> ids;

    public AuthorityDto(List<Authority> allAuthority, List<Integer> ids) {
        this.allAuthority = allAuthority;
        this.ids = ids;
    }

    public AuthorityDto() {
    }

    public List<Authority> getAllAuthority() {
        return allAuthority;
    }

    public void setAllAuthority(List<Authority> allAuthority) {
        this.allAuthority = allAuthority;
    }

    public List<Integer> getIds() {
        return ids;
    }

    public void setIds(List<Integer> ids) {
        this.ids = ids;
    }
}
