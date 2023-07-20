package net.yunzhanyi.client.domain.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author bestct
 * @date 2023/7/14
 */

@Getter
@Setter
@ToString
@ApiModel
public class LoginVo {

    @ApiModelProperty("账号")
    private String account;
    @ApiModelProperty("密码")
    private String password;
}
