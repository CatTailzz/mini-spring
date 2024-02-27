package com.cattail.springframework.context.annotation;

import java.lang.annotation.*;

/**
 * @description: 用于配置作用域的自定义注解
 * @author：CatTail
 * @date: 2024/2/27
 * @Copyright: https://github.com/CatTailzz
 */

@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Scope {

    String value() default "singleton";
}
