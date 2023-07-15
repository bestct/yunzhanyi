package net.yunzhanyi.client.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * @author bestct
 * @date 2022/8/11
 * @type 注解
 */
@Documented
@Retention(RUNTIME)
@Target(METHOD)
public @interface AccountPublic {

}
