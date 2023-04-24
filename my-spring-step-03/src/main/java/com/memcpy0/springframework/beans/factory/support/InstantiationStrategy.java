package com.memcpy0.springframework.beans.factory.support;

import com.memcpy0.springframework.beans.BeansException;
import com.memcpy0.springframework.beans.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;

public interface InstantiationStrategy {
    Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor ctor, Object[] args) throws BeansException;
}
