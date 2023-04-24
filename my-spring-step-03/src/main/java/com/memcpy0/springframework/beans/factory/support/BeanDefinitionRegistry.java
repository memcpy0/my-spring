package com.memcpy0.springframework.beans.factory.support;

import com.memcpy0.springframework.beans.factory.config.BeanDefinition;

public interface BeanDefinitionRegistry {
    void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);
}
