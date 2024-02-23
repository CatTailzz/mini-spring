package com.cattail.springframework.beans.factory;

import com.cattail.springframework.beans.BeansException;

/**
 * @description: 实现此接口的Bean对象，会在BeanFactory设置属性后做出相应处理
 * @author：CatTail
 * @date: 2024/2/23
 * @Copyright: https://github.com/CatTailzz
 */
public interface InitializingBean {

    /**
     * Bean处理属性填充后使用
     *
     * @throws BeansException
     */
    void afterPropertiesSet() throws BeansException;
}
