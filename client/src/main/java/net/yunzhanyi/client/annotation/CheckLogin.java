package net.yunzhanyi.client.annotation;


import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * 检测登录注解
 *
 * @author bestct
 */
@Documented
@Retention(RUNTIME)
@Target(METHOD)
public @interface CheckLogin {

}
