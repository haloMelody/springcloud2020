package com.tl.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * <pre>
 * Description
 * @author T-Dragon
 * 2020/4/16 10:49
 * </pre>
 */
@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
public class PaymentMain8002 {

	public static void main(String[] args) {
		SpringApplication.run(PaymentMain8002.class, args);
	}
}
