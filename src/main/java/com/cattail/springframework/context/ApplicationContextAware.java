package com.cattail.springframework.context;

import com.cattail.springframework.beans.BeansException;
import com.cattail.springframework.beans.factory.Aware;

/**
 * @description: 实现此接口可以感知到所属的ApplicationContext
 * @author：CatTail
 * @date: 2024/2/23
 * @Copyright: https://github.com/CatTailzz
 */
public interface ApplicationContextAware extends Aware {

    void setApplicationContext(ApplicationContext applicationContext) throws BeansException;
}
