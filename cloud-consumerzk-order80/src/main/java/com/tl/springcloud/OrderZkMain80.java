package com.tl.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * <pre>
 * Description
 * @author T-Dragon
 * 2020/4/19 16:11
 * </pre>
 */
@SpringBootApplication
@EnableDiscoveryClient
public class OrderZkMain80 {

	public static void main(String[] args) {
		SpringApplication.run(OrderZkMain80.class, args);
	}

}
