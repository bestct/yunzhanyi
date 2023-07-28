package net.yunzhanyi.admin.model.query;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import net.yunzhanyi.admin.common.base.BasePageQuery;

@Schema(description ="字典类型分页查询对象")
@Data
public class DictTypePageQuery extends BasePageQuery {

    @Schema(description="关键字(类型名称/类型编码)")
    private String keywords;

}
