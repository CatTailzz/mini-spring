package com.cattail.springframework.aop.framework;

import com.sun.corba.se.spi.ior.ObjectKey;
import org.aopalliance.intercept.MethodInvocation;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Method;

/**
 * @description:
 * @author：CatTail
 * @date: 2024/2/26
 * @Copyright: https://github.com/CatTailzz
 */
public class ReflectiveMethodInvocation implements MethodInvocation {

    protected final Object target;

    protected final Method method;

    protected final Object[] arguments;

    public ReflectiveMethodInvocation(Object target, Method method, Object[] arguments) {
        this.target = target;
        this.method = method;
        this.arguments = arguments;
    }

    @Override
    public Method getMethod() {
        return method;
    }

    @Override
    public Object[] getArguments() {
        return arguments;
    }

    @Override
    public Object proceed() throws Throwable {
        return method.invoke(target, arguments);
    }

    @Override
    public Object getThis() {
        return target;
    }

    @Override
    public AccessibleObject getStaticPart() {
        return method;
    }
}
