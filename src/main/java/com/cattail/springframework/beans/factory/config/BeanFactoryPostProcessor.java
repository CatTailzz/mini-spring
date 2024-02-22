package com.cattail.springframework.beans.factory.config;

import com.cattail.springframework.beans.BeansException;
import com.cattail.springframework.beans.factory.ConfigurableListableBeanFactory;

/**
 * @description: 允许自定义修改BeaDefinition属性信息
 * @author：CatTail
 * @date: 2024/2/22
 * @Copyright: https://github.com/CatTailzz
 */
public interface BeanFactoryPostProcessor {

    /**
     * 在所有BeantinDefinitino加载完成后，在实例化Bean对象之前，提供修改BeantioDefinition属性的机制
     * @param beanFactory
     * @throws BeansException
     */
    void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException;
}
