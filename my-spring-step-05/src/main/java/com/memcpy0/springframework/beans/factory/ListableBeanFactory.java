package com.memcpy0.springframework.beans.factory;


import com.memcpy0.springframework.beans.BeansException;

import java.util.Map;

/**
 * Extension of the {@link BeanFactory} interface to be implemented by bean factories
 * that can enumerate all their bean instances, rather than attempting bean lookup
 * by name one by one as requested by clients. BeanFactory implementations that
 * preload all their bean definitions (such as XML-based factories) may implement
 * this interface.
 * BeanFactory接口的扩展，由Bean工厂实现，可以枚举其所有的Bean实例，而不是据客户端的请求逐个尝试按名称查找bean
 * 预加载所有bean定义的BeanFactory实现（例如基于XML的工厂）可以实现这个接口。
 * <p>
 */
public interface ListableBeanFactory extends BeanFactory {
    /**
     * 按照类型返回 Bean 实例
     * @param type
     * @param <T>
     * @return
     * @throws BeansException
     */
    <T> Map<String, T> getBeansOfType(Class<T> type) throws BeansException;

    /**
     * 返回注册表中所有的Bean名称
     * Return the names of all beans defined in this registry.
     * @return
     */
    String[] getBeanDefinitionNames();
}
