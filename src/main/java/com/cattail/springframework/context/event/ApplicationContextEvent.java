package com.cattail.springframework.context.event;

import com.cattail.springframework.context.ApplicationContext;
import com.cattail.springframework.context.ApplicationEvent;

/**
 * @description: ApplicationContext的事件基类
 * @author：CatTail
 * @date: 2024/2/25
 * @Copyright: https://github.com/CatTailzz
 */
public class ApplicationContextEvent extends ApplicationEvent {

    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public ApplicationContextEvent(Object source) {
        super(source);
    }

    public final ApplicationContext getApplicationContext() {
        return (ApplicationContext) getSource();
    }
}
