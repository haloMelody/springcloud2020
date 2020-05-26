package com.tl.springcloud;

import com.tl.murule.MyRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * <pre>
 * Description
 * @author T-Dragon
 * 2020/4/16 15:16
 * </pre>
 */
@SpringBootApplication
@EnableEurekaClient
@RibbonClient(name = "CLOUD-PAYMENT-SERVICE", configuration = MyRule.class)
public class OrderMain80 {

	public static void main(String[] args) {
		SpringApplication.run(OrderMain80.class, args);
	}

}
