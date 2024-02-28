package com.cattail.springframework.beans.factory.support;

import com.cattail.springframework.beans.BeansException;
import com.cattail.springframework.beans.factory.DisposableBean;
import com.cattail.springframework.beans.factory.ObjectFactory;
import com.cattail.springframework.beans.factory.config.SingletonBeanRegistry;


import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @description: 通用的单例注册表,管理注册和销毁
 * @author：CatTail
 * @date: 2024/2/19
 * @Copyright: https://github.com/CatTailzz
 */
public class DefaultSingletonBeanRegistry implements SingletonBeanRegistry {

    protected static final Object NULL_OBJECT = new Object();

    /**
     * 一级缓存，普通对象
     */
    private Map<String, Object> singletonObjects = new HashMap<>();

    /**
     * 二级缓存，提前暴露对象，没有完全实例化的对象
     */
    protected final Map<String, Object> earlySingletonObjects = new HashMap<String, Object>();

    /**
     * 三级缓存，存放代理对象
     */
    private final Map<String, ObjectFactory<?>> singletonFactories = new HashMap<String, ObjectFactory<?>>();

    private final Map<String, DisposableBean> disposableBeanMap = new HashMap<>();

    @Override
    public Object getSingleton(String beanName) {
        Object singletonObject = singletonObjects.get(beanName);
        if (null == singletonObject) {
            singletonObject = earlySingletonObjects.get(beanName);
            if (null == singletonObject) {
                //那么就是代理对象
                ObjectFactory<?> singletonFactory = singletonFactories.get(beanName);
                if (singletonFactory != null) {
                    singletonObject = singletonFactory.getObject();
                    //把三级缓存中的代理对象中的真实对象获取出来，放入二级缓存
                    earlySingletonObjects.put(beanName, singletonObject);
                    singletonFactories.remove(beanName);
                }
            }
        }
        return singletonObject;
    }

    //注册成品
    @Override
    public void registerSingleton(String beanName, Object singletonObject) {
        singletonObjects.put(beanName, singletonObject);
        earlySingletonObjects.remove(beanName);
        singletonFactories.remove(beanName);
    }

    protected void addSingletonFactory(String beanName, ObjectFactory<?> singletonFactory) {
        //如果一级中没有，就放入三级，保险起见把二级也清一下
        if (!this.singletonObjects.containsKey(beanName)) {
            this.singletonFactories.put(beanName, singletonFactory);
            this.earlySingletonObjects.remove(beanName);
        }
    }

    public void registerDisposableBean(String beanName, DisposableBean bean) {
        disposableBeanMap.put(beanName, bean);
    }

    public void destroySingletons() {
        Set<String> keySet = this.disposableBeanMap.keySet();
        Object[] disposableBeanNames = keySet.toArray();

        for (int i = disposableBeanNames.length - 1; i >= 0; i--) {
            Object beanName = disposableBeanNames[i];
            DisposableBean disposableBean = disposableBeanMap.remove(beanName);
            try {
                disposableBean.destory();
            } catch (Exception e) {
                throw new BeansException("Destroy method on bean with name '" + beanName + "' throw an exception", e);
            }
        }
    }

}
