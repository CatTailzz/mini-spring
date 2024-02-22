package com.cattail.springframework.beans.factory.config;

import com.cattail.springframework.beans.BeansException;

/**
 * @description: 用于修改新实例化Bean对象的扩展点
 * @author：CatTail
 * @date: 2024/2/22
 * @Copyright: https://github.com/CatTailzz
 */
public interface BeanPostProcessor {

    /**
     * 在Bean对象初始化方法之前，执行此方法
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException;


    /**
     * 在Bean对象执行初始化方法之后，执行此方法
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException;
}
