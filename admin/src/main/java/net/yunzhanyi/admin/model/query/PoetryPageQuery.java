package net.yunzhanyi.admin.model.query;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import net.yunzhanyi.admin.common.base.BasePageQuery;

/**
 * @author bestct
 * @date 2023/7/31
 * description: TODO
 */

@Data
@Schema
public class PoetryPageQuery extends BasePageQuery {

    @Schema(description="诗词标题")
    private String poetryTitle;

}
