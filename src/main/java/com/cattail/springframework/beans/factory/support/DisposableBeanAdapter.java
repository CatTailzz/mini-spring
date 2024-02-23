package com.cattail.springframework.beans.factory.support;

import cn.hutool.core.util.StrUtil;
import com.cattail.springframework.beans.BeansException;
import com.cattail.springframework.beans.factory.DisposableBean;
import com.cattail.springframework.beans.factory.config.BeanDefinition;

import java.lang.reflect.Method;

/**
 * @description: 销毁方法的适配器,目的是统一不同方式的销毁【配置方式、实现接口方式】
 * @author：CatTail
 * @date: 2024/2/23
 * @Copyright: https://github.com/CatTailzz
 */
public class DisposableBeanAdapter implements DisposableBean {

    private final Object bean;
    private final String beanName;
    private String destroyMethodName;

    public DisposableBeanAdapter(Object bean, String beanName, BeanDefinition beanDefinition) {
        this.bean = bean;
        this.beanName = beanName;
        this.destroyMethodName = beanDefinition.getDestroyMethodName();
    }

    @Override
    public void destory() throws Exception {
        // 1.检查bean是否实现了DisposableBean
        if (bean instanceof DisposableBean) {
            ((DisposableBean) bean).destory();
        }

        // 2.配置方式的销毁，第二个条件是为了避免接口方式的销毁，发生二次销毁
        if (StrUtil.isNotEmpty(destroyMethodName) && !(bean instanceof DisposableBean && "destroy".equals(this.destroyMethodName))) {
            Method destroyMethod = bean.getClass().getMethod(destroyMethodName);
            if (null == destroyMethod) {
                throw new BeansException("Could not find a destroy method named '" + destroyMethodName + "' on bean with name '" + beanName + "'");
            }
            destroyMethod.invoke(bean);
        }
    }
}
