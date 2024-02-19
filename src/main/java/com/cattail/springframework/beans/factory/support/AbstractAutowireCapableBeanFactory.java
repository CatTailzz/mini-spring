package com.cattail.springframework.beans.factory.support;

import com.cattail.springframework.beans.BeansException;
import com.cattail.springframework.beans.factory.config.BeanDefinition;

/**
 * @description: 实现默认bean创建的抽象bean工厂超类
 * @author：CatTail
 * @date: 2024/2/19
 * @Copyright: https://github.com/CatTailzz
 */
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory{

    @Override
    protected Object createBean(String beanName, BeanDefinition beanDefinition) throws BeansException {
        Object bean = null;
        try {
            bean = beanDefinition.getBeanClass().newInstance();
        } catch (InstantiationException | IllegalAccessException e){
            throw new BeansException("Instantiation of bean failed", e);
        }

        addSingleton(beanName, bean);
        return bean;
    }
}
