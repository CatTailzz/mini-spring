package com.cattail.springframework.context;

import com.cattail.springframework.beans.factory.HierarchicaBeanFactory;
import com.cattail.springframework.beans.factory.ListableBeanFactory;
import com.cattail.springframework.core.io.ResourceLoader;

/**
 * @description: 应用上下文接口
 * @author：CatTail
 * @date: 2024/2/22
 * @Copyright: https://github.com/CatTailzz
 */
public interface ApplicationContext extends ListableBeanFactory, HierarchicaBeanFactory, ResourceLoader, ApplicationEventPublisher {
}
