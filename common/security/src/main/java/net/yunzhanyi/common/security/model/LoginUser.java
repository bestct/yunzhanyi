package net.yunzhanyi.common.security.model;

import lombok.*;

/**
 * 登录用户
 *
 * @author bestct
 * @date 2023/04/23
 */

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class LoginUser {

    /**
     * 用户唯一标识
     */
    private String token;

    /**
     * 用户名id
     */
    private Long userid;

    /**
     * 用户名
     */
    private String username;

    /**
     *头像地址
     */
    private String avatarUrl;
    /**
     * 登录时间
     */
    private Long loginTime;

    /**
     * 过期时间
     */
    private Long expireTime;

    /**
     * 登录IP地址
     */
    private String ipaddr;

    /**
     * 浏览器
     */
    private String browser;

    /**
     * 登录位置
     */
    private String loginLocation;

    /**
     * 操作系统
     */
    private String os;
}
