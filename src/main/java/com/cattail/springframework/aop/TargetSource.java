package com.cattail.springframework.aop;

import com.cattail.springframework.util.ClassUtils;

/**
 * @description: 被代理的目标对象
 * @author：CatTail
 * @date: 2024/2/26
 * @Copyright: https://github.com/CatTailzz
 */
public class TargetSource {

    private Object target;

    public TargetSource(Object target) {
        this.target = target;
    }

    public Object getTarget() {
        return target;
    }

    /**
     * 获取目标对象所属类实现的所有接口
     * @return
     */
    public Class<?>[] getTargetClass() {
        Class<?> clazz = this.target.getClass();
        clazz = ClassUtils.isCglibProxyClass(clazz) ? clazz.getSuperclass() : clazz;
        return clazz.getInterfaces();
    }
}
