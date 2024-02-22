package com.cattail.springframework.test.common;

import com.cattail.springframework.beans.BeansException;
import com.cattail.springframework.beans.PropertyValue;
import com.cattail.springframework.beans.PropertyValues;
import com.cattail.springframework.beans.factory.ConfigurableListableBeanFactory;
import com.cattail.springframework.beans.factory.config.BeanDefinition;
import com.cattail.springframework.beans.factory.config.BeanFactoryPostProcessor;

/**
 * @description:  实例化Bean对象之前，修改BeanDefinition属性
 * @author：CatTail
 * @date: 2024/2/22
 * @Copyright: https://github.com/CatTailzz
 */
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        BeanDefinition beanDefinition = beanFactory.getBeanDefinition("userService");
        PropertyValues propertyValues = beanDefinition.getPropertyValues();

        propertyValues.addPropertyValue(new PropertyValue("company", "修改！志杰"));
    }
}
