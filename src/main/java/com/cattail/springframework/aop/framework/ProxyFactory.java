package com.cattail.springframework.aop.framework;

import com.cattail.springframework.aop.AdvisedSupport;
import com.sun.nio.sctp.PeerAddressChangeNotification;

/**
 * @description: 代理工厂
 * @author：CatTail
 * @date: 2024/2/27
 * @Copyright: https://github.com/CatTailzz
 */
public class ProxyFactory {

    private AdvisedSupport advisedSupport;

    public ProxyFactory(AdvisedSupport advisedSupport) {
        this.advisedSupport = advisedSupport;
    }

    public Object getProxy() {
        return createAopProxy().getProxy();
    }

    private AopProxy createAopProxy() {
        if (advisedSupport.isProxyTargetClass()) {
            return new Cglib2AopProxy(advisedSupport);
        }
        return new JdkDynamicAopProxy(advisedSupport);
    }
}
