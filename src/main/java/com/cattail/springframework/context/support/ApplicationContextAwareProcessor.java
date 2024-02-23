package com.cattail.springframework.context.support;

import com.cattail.springframework.beans.BeansException;
import com.cattail.springframework.beans.factory.config.BeanPostProcessor;
import com.cattail.springframework.context.ApplicationContext;
import com.cattail.springframework.context.ApplicationContextAware;

/**
 * @description: 通过BeanPostProcessor实现类感知应用上下文对象
 * @author：CatTail
 * @date: 2024/2/23
 * @Copyright: https://github.com/CatTailzz
 */
public class ApplicationContextAwareProcessor implements BeanPostProcessor {

    private final ApplicationContext applicationContext;

    public ApplicationContextAwareProcessor(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof ApplicationContextAware) {
            ((ApplicationContextAware) bean).setApplicationContext(applicationContext);
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
}
