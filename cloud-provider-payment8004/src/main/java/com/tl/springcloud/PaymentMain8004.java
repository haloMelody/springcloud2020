package com.tl.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * <pre>
 * Description
 * @author T-Dragon
 * 2020/4/19 15:18
 * </pre>
 */
@SpringBootApplication
@EnableDiscoveryClient
public class PaymentMain8004 {

	public static void main(String[] args) {
		SpringApplication.run(PaymentMain8004.class, args);
	}

}
