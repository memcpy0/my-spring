package com.memcpy0.test;

import com.memcpy0.springframework.BeanDefinition;
import com.memcpy0.springframework.BeanFactory;
import com.memcpy0.test.bean.UserService;
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
		BeanFactory beanFactory = new BeanFactory();
		// 2. 注册Bean定义
		BeanDefinition beanDefinition = new BeanDefinition(new UserService());
		beanFactory.registerBeanDefinition("userService", beanDefinition);
		// 3. 获取Bean
		UserService userService = (UserService) beanFactory.getBean("userService");
		userService.queryUserInfo();
	}
}
