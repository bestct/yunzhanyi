package net.yunzhanyi.client.service;

import net.yunzhanyi.client.domain.vo.CheckResultVo;
import net.yunzhanyi.client.domain.vo.RhymeCheckVo;

/**
 * @author bestct
 * @date 2023/5/9
 * description: TODO
 */
public interface RhymeService {

    /**
     * 检查押韵
     *
     * @param rhymeCheckVo 押韵检查签证官
     * @return {@link CheckResultVo}
     */
    CheckResultVo checkRhyme(RhymeCheckVo rhymeCheckVo);
}
