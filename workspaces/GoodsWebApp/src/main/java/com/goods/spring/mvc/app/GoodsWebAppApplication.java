package com.goods.spring.mvc.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@SpringBootApplication
@EnableEurekaClient

public class GoodsWebAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(GoodsWebAppApplication.class, args);
	}

}
