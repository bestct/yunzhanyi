package net.yunzhanyi.client.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author bestct
 * @date 2023/5/9
 * description: TODO
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RhymeCheckVo {
    /**
     * 韵书id
     */
    private Integer rhymeBookId = 1;
    /**
     * 检查内容
     */
    private String checkContent="";
    /**
     * 格律类型
     */
    private Integer formType = 1;
    /**
     * 首句类型
     */
    private Integer firstType = 1;
}
