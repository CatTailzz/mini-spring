package com.cattail.springframework.beans.factory.config;

import com.cattail.springframework.beans.factory.HierarchicaBeanFactory;
import com.cattail.springframework.util.StringValueResolver;

/**
 * @description:
 * @author：CatTail
 * @date: 2024/2/21
 * @Copyright: https://github.com/CatTailzz
 */
public interface ConfigurableBeanFactory extends HierarchicaBeanFactory, SingletonBeanRegistry {

    String SCOPE_SINGLETON = "singleton";

    String SCOPE_PROTOTYPE = "prototype";

    void addBeanPostProcessor(BeanPostProcessor beanPostProcessor);

    /**
     * 销毁单例对象
     */
    void destroySingletons();

    /**
     * 为注解属性添加一个字符串解析器
     * @param valueResolver
     */
    void addEmbeddedValueResolver(StringValueResolver valueResolver);

    /**
     * 解析给定的嵌入值
     * @param value
     * @return
     */
    String resolveEmbeddedValue(String value);
}
