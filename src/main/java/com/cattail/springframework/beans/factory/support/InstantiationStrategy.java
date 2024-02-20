package com.cattail.springframework.beans.factory.support;

import com.cattail.springframework.beans.BeansException;
import com.cattail.springframework.beans.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;

/**
 * @description: bean实例化策略接口
 * @author：CatTail
 * @date: 2024/2/20
 * @Copyright: https://github.com/CatTailzz
 */
public interface InstantiationStrategy {

    Object instantiate(BeanDefinition beanDefinition, String name, Constructor ctor, Object[] args) throws BeansException;
}
