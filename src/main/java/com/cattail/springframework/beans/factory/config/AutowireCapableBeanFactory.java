package com.cattail.springframework.beans.factory.config;

import com.cattail.springframework.beans.BeansException;
import com.cattail.springframework.beans.factory.BeanFactory;

/**
 * @description:
 * @author：CatTail
 * @date: 2024/2/21
 * @Copyright: https://github.com/CatTailzz
 */
public interface AutowireCapableBeanFactory extends BeanFactory {

    /**
     * 执行 BeanPostProcessors 接口实现类中的 postProcessBeforeInitialization 方法
     * @param existingBean
     * @param beanName
     * @return
     * @throws BeansException
     */
    Object applyBeanPostProcessorsBeforeInitialization(Object existingBean, String beanName) throws BeansException;


    /**
     * 执行 BeanPostProcessors 接口实现类中的 postProcessAfterInitialization 方法
     * @param existingBean
     * @param beanName
     * @return
     * @throws BeansException
     */
    Object applyBeanPostProcessorsAfterInitialization(Object existingBean, String beanName) throws BeansException;

}
