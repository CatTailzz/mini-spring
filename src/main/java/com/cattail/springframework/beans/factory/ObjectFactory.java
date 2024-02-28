package com.cattail.springframework.beans.factory;

import com.cattail.springframework.beans.BeansException;

/**
 * @description:
 * @author：CatTail
 * @date: 2024/2/28
 * @Copyright: https://github.com/CatTailzz
 */
public interface ObjectFactory<T> {

    T getObject() throws BeansException;
}
