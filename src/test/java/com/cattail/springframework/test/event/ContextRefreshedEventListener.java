package com.cattail.springframework.test.event;

import com.cattail.springframework.context.ApplicationListener;
import com.cattail.springframework.context.event.ContextRefreshedEvent;

/**
 * @description: 容器刷新的事件监听器
 * @author：CatTail
 * @date: 2024/2/25
 * @Copyright: https://github.com/CatTailzz
 */
public class ContextRefreshedEventListener implements ApplicationListener<ContextRefreshedEvent> {
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        System.out.println("刷新事件" + this.getClass().getName());
    }
}
