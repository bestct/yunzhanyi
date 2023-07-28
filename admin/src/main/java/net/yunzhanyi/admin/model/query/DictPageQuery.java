package net.yunzhanyi.admin.model.query;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import net.yunzhanyi.admin.common.base.BasePageQuery;

@Schema(description ="字典数据项分页查询对象")
@Data
public class DictPageQuery extends BasePageQuery {

    @Schema(description="关键字(字典项名称)")
    private String keywords;

    @Schema(description="字典类型编码")
    private String typeCode;
}
