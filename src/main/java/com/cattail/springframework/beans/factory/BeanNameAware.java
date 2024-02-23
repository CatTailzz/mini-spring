package com.cattail.springframework.beans.factory;

/**
 * @description: 实现此接口可以感知到所属的BeanName
 * @author：CatTail
 * @date: 2024/2/23
 * @Copyright: https://github.com/CatTailzz
 */
public interface BeanNameAware extends Aware {

    void setBeanName(String name);
}
