package net.yunzhanyi.admin.model.query;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import net.yunzhanyi.admin.common.base.BasePageQuery;

/**
 * 角色分页查询实体
 *
 * @author haoxr
 * @since 2022/6/3
 *
 */
@Data
public class RolePageQuery extends BasePageQuery {

    @Schema(description="关键字(角色名称/角色编码)")
    private String keywords;
}
