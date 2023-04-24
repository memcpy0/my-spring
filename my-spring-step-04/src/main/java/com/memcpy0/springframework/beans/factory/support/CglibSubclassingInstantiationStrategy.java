package com.memcpy0.springframework.beans.factory.support;

import com.memcpy0.springframework.beans.BeansException;
import com.memcpy0.springframework.beans.factory.config.BeanDefinition;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.NoOp;

import java.lang.reflect.Constructor;

public class CglibSubclassingInstantiationStrategy implements InstantiationStrategy {

    @Override
    public Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor ctor, Object[] args) throws BeansException {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(beanDefinition.getBeanClass()); // 实例化Bean子类
        enhancer.setCallback(new NoOp() {
            @Override
            public int hashCode() {
                return super.hashCode(); // 以Bean的哈希码为码
            }
        });
        if (null == ctor) return enhancer.create();
        return enhancer.create(ctor.getParameterTypes(), args);
    }
}
