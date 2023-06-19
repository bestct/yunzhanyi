package net.yunzhanyi.client.domain.vo;

import lombok.*;
import net.yunzhanyi.domain.pojo.Anthology;

import java.util.List;

/**
 * @author bestct
 * @date 2023/6/19
 * description: TODO
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class AnthologyVo {
    /**
     * 诗集的id
     */
    private Integer anthologyId;


    /**
     * 诗集名字
     */
    private String anthologyName;

    /**
     * 诗集简介
     */
    private String anthologyInfo;

    /**
     * 诗集副标题
     */
    private String subtitle;


    /**
     * 子诗集
     */
    private List<Anthology> subAnthologyList;
}
