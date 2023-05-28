package net.yunzhanyi.client.domain.vo;

import lombok.*;
import net.yunzhanyi.domain.pojo.Author;
import net.yunzhanyi.domain.pojo.PoetryDetail;
import net.yunzhanyi.domain.pojo.Tag;

import java.util.List;

/**
 * @author bestct
 * @date 2023/5/28
 * description: TODO
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class PoetryVo {
    /**
     * 诗词主键
     */
    private Long poetryId;

    /**
     * 诗词标题
     */
    private String poetryTitle;

    /**
     * 诗词朝代
     */
    private String poetryDynasty;

    /**
     * 诗词类型
     */
    private String poetryType;

    /**
     * 诗词作者
     */
    private String poetryAuthor;

    /**
     * 作者id
     */
    private Long authorId;

    /**
     * 诗词内容
     */
    private String poetryContent;

    /**
     * 集合
     */
    private Boolean collection;

    /**
     * 标记列表
     */
    private List<Tag> tagList;


    /**
     * 作者
     */
    private Author author;

    /**
     * 王朝id
     */
    private Integer dynastyId;

    /**
     * 诗歌细节
     */
    private List<PoetryDetail> poetryDetails;

}
