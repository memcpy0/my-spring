package com.memcpy0.springframework.beans.factory;

import com.memcpy0.springframework.beans.BeansException;
import org.springframework.context.annotation.Bean;

public interface BeanFactory {
    Object getBean(String beanName) throws BeansException;
    Object getBean(String beanName, Object... args) throws BeansException;

    <T> T getBean(String name, Class<T> requiredType) throws BeansException;
}
