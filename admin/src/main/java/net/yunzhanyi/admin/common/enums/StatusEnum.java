package net.yunzhanyi.admin.common.enums;

import lombok.Getter;
import net.yunzhanyi.admin.common.base.IBaseEnum;

/**
 * 状态枚举
 *
 * @author haoxr
 * @since 2022/10/14
 */
public enum StatusEnum implements IBaseEnum<Integer> {

    ENABLE(1, "启用"),
    DISABLE (0, "禁用");

    @Getter
    private Integer value;

    @Getter
    private String label;

    StatusEnum(Integer value, String label) {
        this.value = value;
        this.label = label;
    }
}
