package com.cattail.springframework.context.support;

import com.cattail.springframework.beans.BeansException;
import com.cattail.springframework.beans.factory.ConfigurableListableBeanFactory;
import com.cattail.springframework.beans.factory.support.DefaultListableBeanFactory;

import javax.management.DescriptorAccess;

/**
 * @description: 抽象基类刷新应用上下文
 * @author：CatTail
 * @date: 2024/2/22
 * @Copyright: https://github.com/CatTailzz
 */
public abstract class AbstractRefreshableApplicationContext extends AbstractApplicationContext{

    private DefaultListableBeanFactory beanFactory;

    @Override
    protected void refreshBeanFactory() throws BeansException {
        DefaultListableBeanFactory beanFactory = createBeanFactory();
        loadBeanDefinitions(beanFactory);
        this.beanFactory = beanFactory;
    }


    private DefaultListableBeanFactory createBeanFactory() {
        return new DefaultListableBeanFactory();
    }

    protected abstract void loadBeanDefinitions(DefaultListableBeanFactory beanFactory);

    @Override
    protected ConfigurableListableBeanFactory getBeanFactory() {
        return beanFactory;
    }
}
