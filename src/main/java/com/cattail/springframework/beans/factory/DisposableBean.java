package com.cattail.springframework.beans.factory;

/**
 * @description: 可销毁的Bean
 * @author：CatTail
 * @date: 2024/2/23
 * @Copyright: https://github.com/CatTailzz
 */
public interface DisposableBean {

    void destory() throws Exception;
}
