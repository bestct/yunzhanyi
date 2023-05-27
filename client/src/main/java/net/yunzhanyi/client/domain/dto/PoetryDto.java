package net.yunzhanyi.client.domain.dto;

import lombok.*;
import net.yunzhanyi.domain.pojo.Tag;

import java.util.List;

/**
 * @author bestct
 * @date 2023/5/24
 * description: TODO
 */
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class PoetryDto {
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
     *
     */
    private Boolean collection;

    private Integer dynastyId;

    private List<Tag> tagList;

}
