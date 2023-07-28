package net.yunzhanyi.admin.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import net.yunzhanyi.admin.common.model.Option;
import net.yunzhanyi.admin.model.entity.SysDictType;
import net.yunzhanyi.admin.model.form.DictTypeForm;
import net.yunzhanyi.admin.model.query.DictTypePageQuery;
import net.yunzhanyi.admin.model.vo.DictTypePageVO;

import java.util.List;

/**
 * 数据字典类型业务接口
 *
 * @author haoxr
 * @since 2022/10/12
 */
public interface SysDictTypeService extends IService<SysDictType> {

    /**
     * 字典类型分页列表
     *
     * @param queryParams 分页查询对象
     * @return
     */
    Page<DictTypePageVO> getDictTypePage(DictTypePageQuery queryParams);


    /**
     * 获取字典类型表单详情
     *
     * @param id 字典类型ID
     * @return
     */
    DictTypeForm getDictTypeForm(Long id);


    /**
     * 新增字典类型
     *
     * @param dictTypeForm 字典类型表单
     * @return
     */
    boolean saveDictType(DictTypeForm dictTypeForm);


    /**
     * 修改字典类型
     *
     * @param id
     * @param dictTypeForm 字典类型表单
     * @return
     */
    boolean updateDictType(Long id, DictTypeForm dictTypeForm);

    /**
     * 删除字典类型
     *
     * @param idsStr 字典类型ID，多个以英文逗号(,)分割
     * @return
     */
    boolean deleteDictTypes(String idsStr);


    /**
     * 获取字典类型的数据项
     *
     * @param typeCode
     * @return
     */
    List<Option> listDictItemsByTypeCode(String typeCode);
}
