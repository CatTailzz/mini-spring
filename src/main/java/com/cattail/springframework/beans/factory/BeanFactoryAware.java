package com.cattail.springframework.beans.factory;

import com.cattail.springframework.beans.BeansException;

/**
 * @description: 实现此接口可以感知到所属的BeanFactory
 * @author：CatTail
 * @date: 2024/2/23
 * @Copyright: https://github.com/CatTailzz
 */
public interface BeanFactoryAware extends Aware {

    void setBeanFactory(BeanFactory beanFactory) throws BeansException;
}
