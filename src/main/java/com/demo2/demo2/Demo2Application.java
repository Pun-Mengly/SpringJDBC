package com.demo2.demo2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.demo2.demo2")

public class Demo2Application {

	public static void main(String[] args) {
		SpringApplication.run(Demo2Application.class, args);

	}

}
