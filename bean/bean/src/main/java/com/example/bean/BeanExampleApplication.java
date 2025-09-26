package com.example.bean;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class BeanExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(BeanExampleApplication.class, args);

		AnnotationConfigApplicationContext  Context =  new AnnotationConfigApplicationContext(AppConfig.class);
		Payment payment	= Context.getBean( "Google pay",  Payment.class);
		System.out.println(payment.getProviderName());

	      String name =	Context.getBean(String.class);
		System.out.println(name);

	Integer num	= Context.getBean(Integer.class);

		System.out.println(num);

	}

}
