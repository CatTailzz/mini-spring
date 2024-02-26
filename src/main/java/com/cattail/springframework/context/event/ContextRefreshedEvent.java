package com.cattail.springframework.context.event;

/**
 * @description: ApplicationContext被刷新时触发
 * @author：CatTail
 * @date: 2024/2/25
 * @Copyright: https://github.com/CatTailzz
 */
public class ContextRefreshedEvent extends ApplicationContextEvent{

    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public ContextRefreshedEvent(Object source) {
        super(source);
    }
}
