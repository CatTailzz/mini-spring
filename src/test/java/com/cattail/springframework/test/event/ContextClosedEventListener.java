package com.cattail.springframework.test.event;

import com.cattail.springframework.context.ApplicationListener;
import com.cattail.springframework.context.event.ContextClosedEvent;

/**
 * @description: 容器关闭的事件监听器
 * @author：CatTail
 * @date: 2024/2/25
 * @Copyright: https://github.com/CatTailzz
 */
public class ContextClosedEventListener implements ApplicationListener<ContextClosedEvent> {
    @Override
    public void onApplicationEvent(ContextClosedEvent event) {
        System.out.println("关闭事件：" + this.getClass().getName());
    }
}
