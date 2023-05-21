package net.yunzhanyi.admin.body;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 基本身体
 *
 * @author bestct
 * @date 2023/05/05
 */

@Getter
@Setter
@ToString
public class BaseBody {

    /**
     * 页面num
     */
    private Integer pageNum = 1;
    /**
     * 页面大小
     */
    private Integer pageSize = 10;

}
