package com.goods.zuul.api.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

import com.goods.zuul.api.gateway.filters.ErrorFilter;
import com.goods.zuul.api.gateway.filters.PostFilter;
import com.goods.zuul.api.gateway.filters.PreFilter;
import com.goods.zuul.api.gateway.filters.RouteFilter;

 

@SpringBootApplication
@EnableZuulProxy  
@EnableEurekaClient
public class GoodsZuulApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(GoodsZuulApiGatewayApplication.class, args);
	}
	
	@Bean
	public PreFilter preFilter() {
		return new PreFilter();
	}
	@Bean
	public PostFilter postFilter() {
		return new PostFilter();
	}
	@Bean
	public ErrorFilter errorFilter() {
		return new ErrorFilter();
	}
	@Bean
	public RouteFilter routeFilter() {
		return new RouteFilter();
	}

}
