package com.cattail.springframework.context.event;

import com.cattail.springframework.beans.factory.BeanFactory;
import com.cattail.springframework.context.ApplicationEvent;
import com.cattail.springframework.context.ApplicationListener;

import javax.management.ListenerNotFoundException;

/**
 * @description:
 * @author：CatTail
 * @date: 2024/2/25
 * @Copyright: https://github.com/CatTailzz
 */
public class SimpleApplicationEventMulticaster extends AbstractApplicationEventMulticaster{

    public SimpleApplicationEventMulticaster(BeanFactory beanFactory) {
        setBeanFactory(beanFactory);
    }

    @SuppressWarnings("unchecked")
    @Override
    public void multicastEvent(final ApplicationEvent event) {
        for (final ApplicationListener listener : getApplicationListeners(event)) {
            listener.onApplicationEvent(event);
        }
    }
}
