package net.yunzhanyi.client.service;

import net.yunzhanyi.client.domain.vo.CheckResultVo;
import net.yunzhanyi.client.domain.vo.RhymeBookVo;
import net.yunzhanyi.client.domain.vo.RhymeCheckVo;

import java.util.Map;

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

    /**
     * 搜索押韵
     *
     * @param hanZi 汉滋
     * @return {@link Map}<{@link String}, {@link RhymeBookVo}>
     */
    Map<Integer, RhymeBookVo> searchRhyme(String hanZi);
}
