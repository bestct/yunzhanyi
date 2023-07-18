package net.yunzhanyi.client.domain.dto;

import lombok.Data;

import java.util.Date;

/**
 * @author bestct
 * @date 2023/7/18
 * description:
 */
@Data
public class CollectionDto {

    /**
     * id
     */
    private Long id;

    /**
     * 收藏类型
     */
    private Integer collectionType;

    /**
     * 资源id
     */
    private Long resId;


    private String resName;

    /**
     * 收藏时间
     */
    private Date collectionTime;

}
