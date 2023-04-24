package com.memcpy0;

import com.memcpy0.bean.UserService;
import com.memcpy0.springframework.beans.factory.config.BeanDefinition;
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
		BeanDefinition beanDefinition = new BeanDefinition(UserService.class); // 不用自己实例化Bean去传入了
		beanFactory.registerBeanDefinition("userService", beanDefinition); // 注册Bean定义
		// 3. 第一次获取Bean
//		UserService userService = (UserService) beanFactory.getBean("userService"); // 无参构造
//		userService.queryUserInfo();

		// 4. 第二次获取bean from Singleton
		UserService userService_singleton = (UserService) beanFactory.getBean("userService", "memcpy0");
		userService_singleton.queryUserInfo();

//		if (userService == userService_singleton) System.out.println("same instance");
	}
}
