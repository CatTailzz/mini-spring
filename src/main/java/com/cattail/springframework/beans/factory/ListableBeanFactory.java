package com.cattail.springframework.beans.factory;

import com.cattail.springframework.beans.BeansException;

import java.util.Map;

/**
 * @description: 检索容器中注册的bean列表
 * @author：CatTail
 * @date: 2024/2/21
 * @Copyright: https://github.com/CatTailzz
 */
public interface ListableBeanFactory extends BeanFactory{

    /**
     * 按照类型返回bean实例
     * @param type
     * @return
     * @param <T>
     * @throws BeansException
     */
    <T> Map<String, T> getBeansOfType(Class<T> type) throws BeansException;

    /**
     * 返回注册表中所有的bean名称
     * @return
     */
    String[] getBeanDefinitionNames();
}
