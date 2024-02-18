package com.cattail.springframework.test;

import com.cattail.springframework.beans.BeanDefinition;
import com.cattail.springframework.beans.BeanFactory;
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
        BeanFactory beanFactory = new BeanFactory();

        BeanDefinition beanDefinition = new BeanDefinition(new UserService());
        beanFactory.registerBeanDefinition("userService", beanDefinition);

        UserService userService = (UserService) beanFactory.getBean("userService");
        userService.queryUserInfo();
    }


}
