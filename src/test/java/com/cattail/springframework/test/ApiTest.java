package com.cattail.springframework.test;

import com.cattail.springframework.beans.PropertyValue;
import com.cattail.springframework.beans.PropertyValues;
import com.cattail.springframework.beans.factory.config.BeanDefinition;
import com.cattail.springframework.beans.factory.config.BeanReference;
import com.cattail.springframework.beans.factory.support.DefaultListableBeanFactory;
import com.cattail.springframework.test.bean.UserDao;
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

        // 2.注册UserDao
        beanFactory.registerBeanDefinition("userDao", new BeanDefinition(UserDao.class));

        // 3.设置UserService的属性
        PropertyValues propertyValues = new PropertyValues();
        propertyValues.addPropertyValue(new PropertyValue("uId", "1001"));
        propertyValues.addPropertyValue(new PropertyValue("userDao", new BeanReference("userDao")));

        // 4.注册UserService
        BeanDefinition beanDefinition = new BeanDefinition(UserService.class, propertyValues);
        beanFactory.registerBeanDefinition("userService", beanDefinition);

        // 5.第一次获取bean
        UserService userService = (UserService) beanFactory.getBean("userService", "zsj");
        userService.queryUserInfo();

//        // 4.第二次获取bean from singleton
//        UserService userService_singleton = (UserService) beanFactory.getBean("userService");
//       userService_singleton.queryUserInfo();
    }


}
