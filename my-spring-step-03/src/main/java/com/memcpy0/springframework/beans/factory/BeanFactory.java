package com.memcpy0.springframework.beans.factory;

import com.memcpy0.springframework.beans.BeansException;

public interface BeanFactory {
    Object getBean(String beanName) throws BeansException;
    Object getBean(String beanName, Object... args) throws BeansException;
}
