package net.yunzhanyi.admin.model.query;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import net.yunzhanyi.admin.common.base.BasePageQuery;

/**
 * 权限分页查询对象
 *
 * @author haoxr
 * @since 2022/1/14 22:22
 */
@Data
@Schema
public class PermPageQuery extends BasePageQuery {

    @Schema(description="权限名称")
    private String name;

    @Schema(description="菜单ID")
    private Long menuId;

}
