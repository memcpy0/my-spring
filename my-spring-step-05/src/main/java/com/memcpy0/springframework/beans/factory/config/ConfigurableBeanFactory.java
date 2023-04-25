package com.memcpy0.springframework.beans.factory.config;

import com.memcpy0.springframework.beans.factory.HierarchicalBeanFactory;

/**
 * Configuration interface to be implemented by most bean factories. Provides
 * facilities to configure a bean factory, in addition to the bean factory
 * client methods in the {@link com.memcpy0.springframework.beans.factory.BeanFactory}
 * interface.
 * 将由大多数Bean工厂实现的配置接口，提供了配置Bean工厂的方法，还有Bean Factory客户端方法（即一系列getBean方法）
 */
public interface ConfigurableBeanFactory extends HierarchicalBeanFactory, SingletonBeanRegistry {
    String SCOPE_SINGLETON = "singleton";

    String SCOPE_PROTOTYPE = "prototype";
}
