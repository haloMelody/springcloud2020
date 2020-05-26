package com.tl.springcloud.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * <pre>
 * Description
 * @author T-Dragon
 * 2020/4/28 17:53
 * </pre>
 */
@Configuration
public class FeignConfig {

	@Bean
	public Logger.Level feignLoggerLevel(){
		return Logger.Level.FULL;
	}
}
