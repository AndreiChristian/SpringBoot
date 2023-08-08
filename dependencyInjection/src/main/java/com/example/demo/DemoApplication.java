package com.example.demo;

import com.example.demo.controllers.MyController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		ApplicationContext ctx =  SpringApplication.run(DemoApplication.class, args);

		MyController myController = ctx.getBean(MyController.class);

		System.out.println("Main method");

		System.out.println(myController.sayHello());

	}

}
