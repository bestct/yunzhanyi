package net.yunzhanyi.client.service;

import net.yunzhanyi.client.domain.vo.AnthologyVo;
import net.yunzhanyi.domain.pojo.Anthology;

import java.util.List;

/**
 * @author bestct
 * @date 2023/5/28
 * description: TODO
 */
public interface AnthologyService {
    List<Anthology> searchIndexAnthology();

    AnthologyVo getAnthologyById(Integer id);

    List<Anthology> getAnthologyList(Integer parentId);
}
