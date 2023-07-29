package net.yunzhanyi.client.domain.vo;

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
public class LoginVo {

    private String account;
    private String password;
}
