package com.memcpy0.springframework.beans.factory.support;

import com.memcpy0.springframework.beans.BeansException;
import com.memcpy0.springframework.beans.factory.ConfigurableListableBeanFactory;
import com.memcpy0.springframework.beans.factory.config.BeanDefinition;

import java.util.HashMap;
import java.util.Map;

public class DefaultListableBeanFactory extends AbstractAutowireCapableBeanFactory
        implements BeanDefinitionRegistry, ConfigurableListableBeanFactory {
    private Map<String, BeanDefinition> beanDefinitionMap = new HashMap<>();

    /**
     * 获取BeanDefinition
     * @param beanName
     * @return
     * @throws BeansException
     */
    @Override
    public BeanDefinition getBeanDefinition(String beanName) throws BeansException {
        BeanDefinition beanDefinition = beanDefinitionMap.get(beanName);
        if (beanDefinition == null)
            throw new BeansException("No bean named '" + beanName + "' is defined");
        return beanDefinition;
    }

    @Override
    public boolean containsBeanDefinition(String beanName) {
        return beanDefinitionMap.containsKey(beanName);
    }

    @Override
    public String[] getBeanDefinitionNames() {
        return beanDefinitionMap.keySet().toArray(new String[0]);
    }

    /**
     * 注册BeanDefinition
     * @param beanName
     * @param beanDefinition
     */
    @Override
    public void registerBeanDefinition(String beanName, BeanDefinition beanDefinition) {
        beanDefinitionMap.put(beanName, beanDefinition);
    }

    /**
     * 返回某种类型的全部Bean
     * @param type
     * @return
     * @param <T>
     * @throws BeansException
     */
    @Override
    public <T> Map<String, T> getBeansOfType(Class<T> type) throws BeansException {
        Map<String, T> result = new HashMap<>();
        beanDefinitionMap.forEach((beanName, beanDefinition) -> {
            Class beanClass = beanDefinition.getBeanClass();
            if (type.isAssignableFrom(beanClass))
                result.put(beanName, (T) getBean(beanName));
        });
        return result;
    }
}
