package com.tl.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * <pre>
 * Description
 * @author T-Dragon
 * 2020/4/16 16:26
 * </pre>
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaMain7002 {

	public static void main(String[] args) {
		SpringApplication.run(EurekaMain7002.class, args);
	}

}
