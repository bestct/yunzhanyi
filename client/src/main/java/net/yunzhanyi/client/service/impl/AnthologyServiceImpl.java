package net.yunzhanyi.client.service.impl;

import net.yunzhanyi.client.domain.vo.AnthologyVo;
import net.yunzhanyi.client.service.AnthologyService;
import net.yunzhanyi.domain.mapper.AnthologyMapper;
import net.yunzhanyi.domain.pojo.Anthology;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author bestct
 * @date 2023/5/28
 * description: TODO
 */
@Service
public class AnthologyServiceImpl implements AnthologyService {

    @Autowired
    private AnthologyMapper anthologyMapper;

    @Override
    public List<Anthology> searchIndexAnthology() {
        List<Anthology> anthologies = anthologyMapper.selectByParentId(0);
        return anthologies;
    }

    @Override
    public AnthologyVo getAnthologyById(Integer id) {
        Anthology anthology = anthologyMapper.selectByPrimaryKey(id.longValue());
        AnthologyVo anthologyVo =new AnthologyVo();
        BeanUtils.copyProperties(anthology,anthologyVo);
        anthologyVo.setSubAnthologyList(getAnthologyList(id));
        return anthologyVo;
    }

    @Override
    public List<Anthology> getAnthologyList(Integer parentId) {
        List<Anthology> anthologies = anthologyMapper.selectListByParentId(parentId);
        return anthologies;
    }
}
