package com.memcpy0.springframework.beans.factory.support;

import com.memcpy0.springframework.beans.BeansException;
import com.memcpy0.springframework.beans.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;

public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory {
//    private InstantiationStrategy instantiationStrategy = new CglibSubclassingInstantiationStrategy();
    private InstantiationStrategy instantiationStrategy = new SimpleInstantiationStrategy();

    @Override
    protected Object createBean(String beanName, BeanDefinition beanDefinition, Object[] args) throws BeansException {
        Object bean = null;
        try {
//            bean = beanDefinition.getBeanClass().newInstance();
            bean = createBeanInstance(beanDefinition, beanName, args);
        } catch (Exception e) {
            throw new BeansException("Instantiation of bean failed", e);
        }
        addSingleton(beanName, bean); // 第一次创建Bean时要加入单例池
        return bean;
    }

    protected Object createBeanInstance(BeanDefinition beanDefinition, String beanName, Object[] args) {
        Constructor constructorToUse = null;
        Class<?> beanClass = beanDefinition.getBeanClass();
        Constructor<?>[] declaredConstructors = beanClass.getDeclaredConstructors(); // 从Class对象获取所有构造函数
        for (Constructor ctor : declaredConstructors) { // 找到合适的构造函数，传给实例化策略
            if (null != args && ctor.getParameterTypes().length == args.length) { // 这里对比起来简化了
                constructorToUse = ctor;
                break;
            }
        }
        return getInstantiationStrategy().instantiate(beanDefinition, beanName, constructorToUse, args);
    }

    public InstantiationStrategy getInstantiationStrategy() {
        return instantiationStrategy;
    }

    public void setInstantiationStrategy(InstantiationStrategy instantiationStrategy) {
        this.instantiationStrategy = instantiationStrategy;
    }
}
