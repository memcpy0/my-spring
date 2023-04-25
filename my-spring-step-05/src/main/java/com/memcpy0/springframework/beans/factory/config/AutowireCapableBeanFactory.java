package com.memcpy0.springframework.beans.factory.config;

import com.memcpy0.springframework.beans.factory.BeanFactory;

/**
 * Extension of the {@link com.memcpy0.springframework.beans.factory.BeanFactory}
 * interface to be implemented by bean factories that are capable of
 * autowiring, provided that they want to expose this functionality for
 * existing bean instances.
 * 由进行自动装配的Bean工厂实现，前提是他们希望为现有的Bean实例公开此功能
 */
public interface AutowireCapableBeanFactory extends BeanFactory {
}