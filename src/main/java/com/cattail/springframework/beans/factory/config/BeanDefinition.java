package com.cattail.springframework.beans.factory.config;

/**
 * @description: 定义bean实例信息
 * @author：CatTail
 * @date: 2024/2/19
 * @Copyright: https://github.com/CatTailzz
 */
public class BeanDefinition {

    private Class beanClass;

    public BeanDefinition(Class beanClass) {
        this.beanClass = beanClass;
    }

    public Class getBeanClass() {
        return beanClass;
    }

    public void setBeanClass(Class beanClass) {
        this.beanClass = beanClass;
    }


}
