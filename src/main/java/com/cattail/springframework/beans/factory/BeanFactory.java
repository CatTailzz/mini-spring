package com.cattail.springframework.beans.factory;

import com.cattail.springframework.beans.BeansException;


/**
 * @description: 定义bean工厂接口
 * @author：CatTail
 * @date: 2024/2/19
 * @Copyright: https://github.com/CatTailzz
 */
public interface BeanFactory {

    /**
     * 返回bean的实例对象
     * @param name
     * @return
     * @throws BeansException
     */
    Object getBean(String name) throws BeansException;


    /**
     * 有参构造的bean实例对象
     * @param name
     * @param args
     * @return
     * @throws BeansException
     */
    Object getBean(String name, Object... args) throws BeansException;

    /**
     * 返回指定范型的对象
     * @param name
     * @param requiredType
     * @return
     * @param <T>
     * @throws BeansException
     */
    <T> T getBean(String name, Class<T> requiredType) throws BeansException;
}
