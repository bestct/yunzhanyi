package net.yunzhanyi.admin.body;

import lombok.*;

/**
 * 登录身体
 *
 * @author bestct
 * @date 2023/04/22
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class LoginBody {
    private String username;
    private String password;
}
