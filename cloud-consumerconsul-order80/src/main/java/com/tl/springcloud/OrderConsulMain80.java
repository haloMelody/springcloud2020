package com.tl.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * <pre>
 * Description
 * @author T-Dragon
 * 2020/4/27 15:50
 * </pre>
 */
@SpringBootApplication
@EnableDiscoveryClient
public class OrderConsulMain80 {
	public static void main(String[] args) {
		SpringApplication.run(OrderConsulMain80.class, args);
	}
}
