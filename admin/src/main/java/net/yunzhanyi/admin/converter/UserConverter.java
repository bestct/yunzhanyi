package net.yunzhanyi.admin.converter;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import net.yunzhanyi.admin.model.bo.UserBO;
import net.yunzhanyi.admin.model.bo.UserFormBO;
import net.yunzhanyi.admin.model.entity.SysUser;
import net.yunzhanyi.admin.model.form.UserForm;
import net.yunzhanyi.admin.model.vo.UserImportVO;
import net.yunzhanyi.admin.model.vo.UserInfoVO;
import net.yunzhanyi.admin.model.vo.UserPageVO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

/**
 * 用户对象转换器
 *
 * @author haoxr
 * @since 2022/6/8
 */
@Mapper(componentModel = "spring")
public interface UserConverter {

    @Mappings({
            @Mapping(target = "genderLabel", expression = "java(net.yunzhanyi.admin.common.base.IBaseEnum.getLabelByValue(bo.getGender(), net.yunzhanyi.admin.common.enums.GenderEnum.class))")
    })
    UserPageVO bo2Vo(UserBO bo);

    Page<UserPageVO> bo2Vo(Page<UserBO> bo);

    UserForm bo2Form(UserFormBO bo);

    UserForm entity2Form(SysUser entity);

    @InheritInverseConfiguration(name = "entity2Form")
    SysUser form2Entity(UserForm entity);

    @Mappings({
            @Mapping(target = "userId", source = "id")
    })
    UserInfoVO entity2UserInfoVo(SysUser entity);

    SysUser importVo2Entity(UserImportVO vo);

}
