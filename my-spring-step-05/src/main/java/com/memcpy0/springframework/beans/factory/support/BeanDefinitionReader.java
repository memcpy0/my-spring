package com.memcpy0.springframework.beans.factory.support;

import com.memcpy0.springframework.beans.BeansException;
import com.memcpy0.springframework.core.io.Resource;
import com.memcpy0.springframework.core.io.ResourceLoader;

/**
 * Simple interface for bean definition readers.
 */
public interface BeanDefinitionReader {
    BeanDefinitionRegistry getRegistry();
    ResourceLoader getResourceLoader();

    void loadBeanDefinitions(Resource resource) throws BeansException;
    void loadBeanDefinitions(Resource... resources) throws BeansException;
    void loadBeanDefinitions(String location) throws BeansException;
}
