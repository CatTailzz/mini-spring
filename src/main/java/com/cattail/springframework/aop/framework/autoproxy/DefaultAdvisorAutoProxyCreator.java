package com.cattail.springframework.aop.framework.autoproxy;

import com.cattail.springframework.aop.*;
import com.cattail.springframework.aop.aspectj.AspectJExpressionPonitcutAdvisor;
import com.cattail.springframework.aop.framework.ProxyFactory;
import com.cattail.springframework.beans.BeansException;
import com.cattail.springframework.beans.PropertyValues;
import com.cattail.springframework.beans.factory.BeanFactory;
import com.cattail.springframework.beans.factory.BeanFactoryAware;
import com.cattail.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import com.cattail.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.aopalliance.aop.Advice;
import org.aopalliance.intercept.MethodInterceptor;

import java.util.Collection;

/**
 * @description:
 * @author：CatTail
 * @date: 2024/2/27
 * @Copyright: https://github.com/CatTailzz
 */
public class DefaultAdvisorAutoProxyCreator implements InstantiationAwareBeanPostProcessor, BeanFactoryAware {

    private DefaultListableBeanFactory beanFactory;

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = (DefaultListableBeanFactory) beanFactory;
    }


    @Override
    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
        return null;
    }

    @Override
    public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
        return true;
    }


    @Override
    public PropertyValues postProcessPropertyValues(PropertyValues pvs, Object bean, String beanName) throws BeansException {
        return pvs;
    }

    private boolean isInfrastructureClass(Class<?> beanClass) {
        return Advice.class.isAssignableFrom(beanClass) || Pointcut.class.isAssignableFrom(beanClass) || Advisor.class.isAssignableFrom(beanClass);
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        //如果是aop基础设施类，则不做处理
        if (isInfrastructureClass(bean.getClass())) {
            return bean;
        }

        Collection<AspectJExpressionPonitcutAdvisor> advisors = beanFactory.getBeansOfType(AspectJExpressionPonitcutAdvisor.class).values();

        for (AspectJExpressionPonitcutAdvisor advisor : advisors) {
            ClassFilter classFilter = advisor.getPointcut().getClassFilter();
            if (!classFilter.matches(bean.getClass())) {
                continue;
            }

            AdvisedSupport advisedSupport = new AdvisedSupport();

            TargetSource targetSource = new TargetSource(bean);
            advisedSupport.setTargetSource(targetSource);
            advisedSupport.setMethodInterceptor((MethodInterceptor) advisor.getAdvice());
            advisedSupport.setMethodMatcher(advisor.getPointcut().getMethodMatcher());
            advisedSupport.setProxyTargetClass(false);

            return new ProxyFactory(advisedSupport).getProxy();
        }
        return bean;
    }

}
