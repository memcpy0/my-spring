package com.memcpy0.springframework.beans.factory.support;

import com.memcpy0.springframework.beans.factory.BeanFactory;
import com.memcpy0.springframework.beans.factory.config.BeanDefinition;
import com.memcpy0.springframework.beans.BeansException;

public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements BeanFactory {
    @Override
    public Object getBean(String beanName) throws BeansException {
//        Object bean = getSingleton(beanName);
//        if (bean != null) {
//            return bean;
//        }
//        BeanDefinition beanDefinition = getBeanDefinition(beanName);
//        return createBean(beanName, beanDefinition);
        return doGetBean(beanName, null);
    }

    @Override
    public Object getBean(String beanName, Object... args) throws BeansException {
        return doGetBean(beanName, args);
    }

    protected <T> T doGetBean(final String beanName, final Object[] args) {
        Object bean = getSingleton(beanName);
        if (bean != null) {
            return (T) bean;
        }
        BeanDefinition beanDefinition = getBeanDefinition(beanName);
        return (T) createBean(beanName, beanDefinition, args);
    }
    protected abstract BeanDefinition getBeanDefinition(String beanName) throws BeansException;
    protected abstract Object createBean(String beanName, BeanDefinition beanDefinition, Object[] args) throws BeansException;
}
