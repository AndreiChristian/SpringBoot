package com.example.demo;

import com.example.demo.controllers.MyController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

@SpringBootTest
class DemoApplicationTests {

	@Autowired
	ApplicationContext applicationContext;

	@Autowired
	MyController myController;

	@Test
	void tesAutowiredOfController(){
		System.out.println(myController.sayHello());
	}

	@Test
	void testGetControllerFromContext(){
		MyController myController = applicationContext.getBean(MyController.class);

		System.out.println(myController.sayHello());
	}

	@Test
	void contextLoads() {
	}

}
