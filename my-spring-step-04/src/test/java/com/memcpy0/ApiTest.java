package com.memcpy0;

import com.memcpy0.bean.UserDao;
import com.memcpy0.bean.UserService;
import com.memcpy0.springframework.beans.PropertyValue;
import com.memcpy0.springframework.beans.PropertyValues;
import com.memcpy0.springframework.beans.factory.BeanFactory;
import com.memcpy0.springframework.beans.factory.config.BeanDefinition;
import com.memcpy0.springframework.beans.factory.config.BeanReference;
import com.memcpy0.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ApiTest {

	@Test
	void contextLoads() {

	}

	@Test
	public void testBeanFactory() {
		// 1. 初始化BeanFactory
		DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
		// 2. 注册Bean
		beanFactory.registerBeanDefinition("userDao", new BeanDefinition(UserDao.class)); // 这里先不管UserDao的hashMap属性

		// UserService设置属性[uId, userDao]
		PropertyValues propertyValues = new PropertyValues();
		propertyValues.addPropertyValue(new PropertyValue("uId", "10001"));
		propertyValues.addPropertyValue(new PropertyValue("userDao", new BeanReference("userDao"))); // 依赖另外一个Bean

		// UserService 注入Bean
		BeanDefinition beanDefinition = new BeanDefinition(UserService.class, propertyValues); // 不用自己实例化Bean去传入了
		beanFactory.registerBeanDefinition("userService", beanDefinition); // 注册Bean定义

		// 4. 获取bean from Singleton
		UserService userService = (UserService) beanFactory.getBean("userService"); // 无参构造初始化
		userService.queryUserInfo();

//		if (userService == userService_singleton) System.out.println("same instance");
	}
}
