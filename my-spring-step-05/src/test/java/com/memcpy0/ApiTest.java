package com.memcpy0;

import cn.hutool.core.io.IoUtil;
import com.memcpy0.bean.UserDao;
import com.memcpy0.bean.UserService;
import com.memcpy0.springframework.beans.PropertyValue;
import com.memcpy0.springframework.beans.PropertyValues;
import com.memcpy0.springframework.beans.factory.BeanFactory;
import com.memcpy0.springframework.beans.factory.config.BeanDefinition;
import com.memcpy0.springframework.beans.factory.config.BeanReference;
import com.memcpy0.springframework.beans.factory.support.DefaultListableBeanFactory;
import com.memcpy0.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import com.memcpy0.springframework.core.io.DefaultResourceLoader;
import com.memcpy0.springframework.core.io.Resource;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.io.InputStream;

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
		String result = userService.queryUserInfo();
		System.out.println("测试结果：" + result);

//		if (userService == userService_singleton) System.out.println("same instance");
	}

	private static DefaultResourceLoader resourceLoader;

	@BeforeAll
	public static void init() {
		resourceLoader = new DefaultResourceLoader();
	}

	@Test
	public void test_classpath() throws IOException {
		Resource resource = resourceLoader.getResource("classpath:important.properties");
		InputStream inputStream = resource.getInputStream();
		String content = IoUtil.readUtf8(inputStream);
		System.out.println(content);
	}

	@Test
	public void test_file() throws IOException {
		Resource resource = resourceLoader.getResource("src/main/resources/important.properties");
		InputStream inputStream = resource.getInputStream();
		String content = IoUtil.readUtf8(inputStream);
		System.out.println(content);
	}

	@Test
	public void test_url() throws IOException {
		Resource resource = resourceLoader.getResource("https://github.com/fuzhengwei/small-spring/important.properties");
		InputStream inputStream = resource.getInputStream();
		String content = IoUtil.readUtf8(inputStream);
		System.out.println(content);
	}

	@Test
	public void test_xml() {
		// 1.初始化 BeanFactory
		DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

		// 2. 读取配置文件&注册Bean
		XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
		reader.loadBeanDefinitions("classpath:spring.xml");

		// 3. 获取Bean对象调用方法
		UserService userService = beanFactory.getBean("userService", UserService.class);
		String result = userService.queryUserInfo();
		System.out.println("测试结果：" + result);
	}
}
