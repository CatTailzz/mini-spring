package com.cattail.springframework.beans.factory;

import com.cattail.springframework.beans.BeansException;
import com.cattail.springframework.beans.factory.config.BeanDefinition;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

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


}
