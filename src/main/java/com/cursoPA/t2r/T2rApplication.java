package com.cursoPA.t2r;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class T2rApplication {

	public static void main(String[] args) {
		SpringApplication.run(T2rApplication.class, args);
	}
	
}
