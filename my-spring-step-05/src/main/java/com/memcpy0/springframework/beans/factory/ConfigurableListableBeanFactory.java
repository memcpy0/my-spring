package com.memcpy0.springframework.beans.factory;

import com.memcpy0.springframework.beans.factory.config.AutowireCapableBeanFactory;
import com.memcpy0.springframework.beans.factory.config.ConfigurableBeanFactory;

/**
 * Configuration interface to be implemented by most listable bean factories.
 * In addition to {@link com.memcpy0.springframework.beans.factory.config.ConfigurableBeanFactory},
 * it provides facilities to analyze and modify bean definitions, and to pre-instantiate singletons.
 * 将由大多数Bean工厂实现的配置接口，提供了配置Bean工厂的方法，还有分析和修改Bean定义以及提前实例化单例的操作接口
 */
public interface ConfigurableListableBeanFactory extends ListableBeanFactory, AutowireCapableBeanFactory, ConfigurableBeanFactory  {
}
