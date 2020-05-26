package com.tl.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * <pre>
 * Description
 * @author T-Dragon
 * 2020/4/16 15:21
 * </pre>
 */
@Configuration
public class ApplicationContextConfig {

	@Bean
	// @LoadBalanced
	public RestTemplate getRestTemplate(){
		return new RestTemplate();
	}

}
