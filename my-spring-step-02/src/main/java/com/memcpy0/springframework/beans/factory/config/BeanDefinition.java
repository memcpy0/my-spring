package com.memcpy0.springframework.beans.factory.config;

/**
 * 存储Bean的类信息
 */
public class BeanDefinition {
    private Class beanClass;
    public BeanDefinition(Class beanClass) {
        this.beanClass = beanClass;
    }
    public Class getBeanClass() {
        return beanClass;
    }
    public void setBeanClass(Class beanClass) {
        this.beanClass = beanClass;
    }
}
