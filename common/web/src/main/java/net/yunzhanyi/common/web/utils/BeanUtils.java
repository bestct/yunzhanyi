package net.yunzhanyi.common.web.utils;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @author bestct
 * @date 2023/4/28
 * description: TODO
 */
@Component
public class BeanUtils implements ApplicationContextAware, DisposableBean {
    private static ApplicationContext applicationContext;

    @Override
    public void destroy() throws Exception {
        applicationContext = null;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        BeanUtils.applicationContext = applicationContext;
    }
    /**
     *    获取applicationContext
     */
    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    /**
     *     通过name获取 Bean.
     */
    public static <T> T getBean(String name) {
        return (T) getApplicationContext().getBean(name);
    }

    /**
     *     通过class获取Bean.
     */
    public static <T> T getBean(Class<T> clazz) {
        return getApplicationContext().getBean(clazz);
    }

    /**
     *     通过name,以及Clazz返回指定的Bean
     */
    public static <T> T getBean(String name, Class<T> clazz) {
        return getApplicationContext().getBean(name, clazz);
    }

}
