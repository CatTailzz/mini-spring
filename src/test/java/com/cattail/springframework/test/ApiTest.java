package com.cattail.springframework.test;

import com.cattail.springframework.beans.factory.config.BeanDefinition;
import com.cattail.springframework.beans.factory.support.DefaultListableBeanFactory;
import com.cattail.springframework.test.bean.UserService;
import org.junit.Test;


/**
 * @description:
 * @author：CatTail
 * @date: 2024/2/19
 * @Copyright: https://github.com/CatTailzz
 */

public class ApiTest {

    @Test
    public void test_BeanFactory() {
        // 1.初始化beanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        // 2.注册bean
        BeanDefinition beanDefinition = new BeanDefinition(UserService.class);
        beanFactory.registerBeanDefinition("userService", beanDefinition);
        // 3.第一次获取bean
        UserService userService = (UserService) beanFactory.getBean("userService");
        userService.queryUserInfo();
        // 4.第二次获取bean from singleton
        UserService userService_singleton = (UserService) beanFactory.getBean("userService");
       userService_singleton.queryUserInfo();
    }


}
