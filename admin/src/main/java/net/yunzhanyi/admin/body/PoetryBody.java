package net.yunzhanyi.admin.body;

import lombok.Getter;
import lombok.Setter;

/**
 * 诗歌身体
 *
 * @author bestct
 * @date 2023/05/06
 */

@Setter
@Getter
public class PoetryBody extends BaseBody{

    /**
     * 诗词标题
     */
    private String poetryTitle;

    /**
     * 诗词
     */
    private Integer dynastyId;

    /**
     * 诗词类型
     */
    private String poetryType;


    /**
     * 诗词内容
     */
    private String poetryContent;
}
