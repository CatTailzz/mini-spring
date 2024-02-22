package com.cattail.springframework.test.common;

import com.cattail.springframework.beans.BeansException;
import com.cattail.springframework.beans.factory.config.BeanPostProcessor;
import com.cattail.springframework.test.bean.UserService;

/**
 * @description: 在bean对象初始化方法前后进行扩展
 * @author：CatTail
 * @date: 2024/2/22
 * @Copyright: https://github.com/CatTailzz
 */
public class MyBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if ("userService".equals(beanName)) {
            UserService userService = (UserService) bean;
            userService.setLocation("修改！北京");
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
}
