package com.cattail.springframework.test.bean;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * @description:
 * @author：CatTail
 * @date: 2024/2/26
 * @Copyright: https://github.com/CatTailzz
 */
public class UserServiceInterceptor implements MethodInterceptor {

    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        long start = System.currentTimeMillis();
        try {
            return methodInvocation.proceed();
        } finally {
            System.out.println("begin by aop");
            System.out.println("method" + methodInvocation.getMethod());
            System.out.println("takes time " + (System.currentTimeMillis() - start) + "ms");
            System.out.println("end by aop");
        }
    }
}
