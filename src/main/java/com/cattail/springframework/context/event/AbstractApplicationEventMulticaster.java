package com.cattail.springframework.context.event;

import com.cattail.springframework.beans.BeansException;
import com.cattail.springframework.beans.factory.BeanFactory;
import com.cattail.springframework.beans.factory.BeanFactoryAware;
import com.cattail.springframework.context.ApplicationEvent;
import com.cattail.springframework.context.ApplicationEventPublisher;
import com.cattail.springframework.context.ApplicationListener;
import com.cattail.springframework.util.ClassUtils;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * @description: 事件广播器公共方法提取
 * @author：CatTail
 * @date: 2024/2/25
 * @Copyright: https://github.com/CatTailzz
 */
public abstract class AbstractApplicationEventMulticaster implements ApplicationEventMulticaster, BeanFactoryAware {

    public final Set<ApplicationListener<ApplicationEvent>> applicationListeners = new LinkedHashSet<>();

    private BeanFactory beanFactory;

    @Override
    public void addApplicationListener(ApplicationListener<?> listener) {
        applicationListeners.add((ApplicationListener<ApplicationEvent>) listener);
    }

    @Override
    public void removeApplicationListener(ApplicationListener<?> listener) {
        applicationListeners.remove(listener);
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
    }

    /**
     * 获取事件匹配的所有监听器
     * @param event
     * @return
     */
    protected Collection<ApplicationListener> getApplicationListeners(ApplicationEvent event) {
        LinkedList<ApplicationListener> allListener = new LinkedList<ApplicationListener>();
        for (ApplicationListener<ApplicationEvent> listener : applicationListeners) {
            if (supportsEvent(listener, event)) {
                allListener.add(listener);
            }
        }
        return allListener;
    }

    /**
     * 【监听器listener】是否匹配【事件event】
     * @param listener
     * @param event
     * @return
     */
    protected boolean supportsEvent(ApplicationListener<ApplicationEvent> listener, ApplicationEvent event) {
        //获取监听器的运行时类
        Class<? extends ApplicationListener> listenerClass = listener.getClass();

        Class<?> targetClass = ClassUtils.isCglibProxyClass(listenerClass) ? listenerClass.getSuperclass() : listenerClass;
        //获取targetClass所实现的第一个范型接口的类型信息
        Type genericInterface = targetClass.getGenericInterfaces()[0];

        Type actualTypeArgument = ((ParameterizedType) genericInterface).getActualTypeArguments()[0];
        //className即listener的范型，也就是运行时的事件类型
        String className = actualTypeArgument.getTypeName();
        Class<?> eventClassName;
        try {
            eventClassName = Class.forName(className);
        } catch (ClassNotFoundException e) {
            throw new BeansException("wrong event class name: " + className);
        }

        return eventClassName.isAssignableFrom(event.getClass());
    }


}
