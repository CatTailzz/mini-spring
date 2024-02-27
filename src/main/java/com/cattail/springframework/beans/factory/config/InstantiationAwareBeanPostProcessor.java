package com.cattail.springframework.beans.factory.config;

import com.cattail.springframework.beans.BeansException;

/**
 * @description:
 * @author：CatTail
 * @date: 2024/2/27
 * @Copyright: https://github.com/CatTailzz
 */
public interface InstantiationAwareBeanPostProcessor extends BeanPostProcessor{


    /**
     * 在bean对象初始化方法之前，执行此方法
     * @param beanClass
     * @param beanName
     * @return
     * @throws BeansException
     */
    Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException;
}
