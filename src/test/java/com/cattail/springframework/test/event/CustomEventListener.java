package com.cattail.springframework.test.event;

import com.cattail.springframework.context.ApplicationListener;

import java.util.Date;

/**
 * @description: 自定义事件CustomEvent的监听器
 * @author：CatTail
 * @date: 2024/2/25
 * @Copyright: https://github.com/CatTailzz
 */
public class CustomEventListener implements ApplicationListener<CustomEvent> {

    @Override
    public void onApplicationEvent(CustomEvent event) {
        System.out.println("收到：" + event.getSource() + "消息;时间：" + new Date());
        System.out.println("消息：" + event.getId() + ":" + event.getMessage());
    }
}
