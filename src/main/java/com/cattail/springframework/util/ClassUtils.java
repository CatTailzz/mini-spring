package com.cattail.springframework.util;

/**
 * @description:
 * @author：CatTail
 * @date: 2024/2/21
 * @Copyright: https://github.com/CatTailzz
 */
public class ClassUtils {

    public static ClassLoader getDefaultClassLoader() {
        ClassLoader cl = null;
        try {
            cl = Thread.currentThread().getContextClassLoader();
        } catch (Throwable ex) {

        }
        if (cl == null) {
            cl = ClassUtils.class.getClassLoader();
        }
        return cl;
    }

    public static boolean isCglibProxyClass(Class<?> clazz) {
        return (clazz != null && isCglibProxyClassName(clazz.getName()));
    }

    private static boolean isCglibProxyClassName(String className) {
        return (className != null && className.contains("$$"));
    }
}
