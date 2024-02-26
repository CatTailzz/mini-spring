package com.cattail.springframework.context.event;


import com.cattail.springframework.context.ApplicationEvent;
import com.cattail.springframework.context.ApplicationListener;

/**
 * @description: 事件广播器接口
 * @author：CatTail
 * @date: 2024/2/25
 * @Copyright: https://github.com/CatTailzz
 */
public interface ApplicationEventMulticaster {

    /**
     * 给所有事件添加监听器
     * @param listener
     */
    void addApplicationListener(ApplicationListener<?> listener);

    /**
     * 从通知列表中移除监听器
     * @param listener
     */
    void removeApplicationListener(ApplicationListener<?> listener);

    /**
     * 将给定的事件广播到适当的监听器
     * @param event
     */
    void multicastEvent(ApplicationEvent event);
}
