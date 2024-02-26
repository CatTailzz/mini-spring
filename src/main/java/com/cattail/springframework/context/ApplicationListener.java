package com.cattail.springframework.context;

import java.util.EventListener;

/**
 * @description: 监听器接口，范型是监听的事件类型
 * @author：CatTail
 * @date: 2024/2/25
 * @Copyright: https://github.com/CatTailzz
 */
public interface ApplicationListener<E extends ApplicationEvent> extends EventListener {

    /**
     * 处理 ApplicationEvent，由具体的listener实现
     * @param event
     */
    void onApplicationEvent(E event);
}
