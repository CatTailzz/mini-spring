package com.cattail.springframework.context.annotation;

import cn.hutool.core.util.ClassUtil;
import com.cattail.springframework.beans.factory.config.BeanDefinition;
import com.cattail.springframework.stereotype.Component;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @description: 扫描包路径获取带注解的class
 * @author：CatTail
 * @date: 2024/2/27
 * @Copyright: https://github.com/CatTailzz
 */
public class ClassPathScanningCandidateComponentProvider {

    public Set<BeanDefinition> findCandidateComponents(String basePackage) {
        Set<BeanDefinition> candidates = new LinkedHashSet<>();
        Set<Class<?>> classes = ClassUtil.scanPackageByAnnotation(basePackage, Component.class);
        for (Class<?> clazz : classes) {
            candidates.add(new BeanDefinition(clazz));
        }
        return candidates;
    }
}
