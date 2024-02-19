package com.cattail.springframework.beans.factory.support;

import com.cattail.springframework.beans.factory.config.BeanDefinition;

/**
 * @description: 定义注册接口
 * @author：CatTail
 * @date: 2024/2/19
 * @Copyright: https://github.com/CatTailzz
 */
public interface BeanDefinitionRegistry {

    /**
     * 向注册表中注测BeanDefinition
     * @param beanName
     * @param beanDefinition
     */
    void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);
}
