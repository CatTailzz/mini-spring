package com.cattail.springframework.beans.factory.support;

import com.cattail.springframework.beans.BeansException;
import com.cattail.springframework.beans.factory.BeanFactory;
import com.cattail.springframework.beans.factory.config.BeanDefinition;

/**
 * @description: 抽象的bean工厂基类，定义模板方法
 * @author：CatTail
 * @date: 2024/2/19
 * @Copyright: https://github.com/CatTailzz
 */
public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements BeanFactory {

    @Override
    public Object getBean(String name) throws BeansException {
        return doGetBean(name, null);
    }

    @Override
    public Object getBean(String name, Object... args) throws BeansException {
        return doGetBean(name, args);
    }

    protected <T> T doGetBean(final String name, final Object[] args) {
        Object bean = getSingleton(name);
        if (bean != null) {
            return (T) bean;
        }

        BeanDefinition beanDefinition = getBeanDefinition(name);
        return (T) createBean(name, beanDefinition, args);
    }

    protected abstract BeanDefinition getBeanDefinition(String beanName);

    protected abstract Object createBean(String name, BeanDefinition beanDefinition, Object[] args);

}
