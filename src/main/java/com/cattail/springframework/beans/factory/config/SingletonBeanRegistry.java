package com.cattail.springframework.beans.factory.config;

/**
 * @description: 单例bean注册表
 * @author：CatTail
 * @date: 2024/2/19
 * @Copyright: https://github.com/CatTailzz
 */
public interface SingletonBeanRegistry {

    /**
     * 返回在给定名称下注册的单例对象
     * @param beanName
     * @return
     */
    Object getSingleton(String beanName);

    /**
     * 注册单例对象
     * @param beanName
     * @param singletonObject
     */
    void registerSingleton(String beanName, Object singletonObject);
}
