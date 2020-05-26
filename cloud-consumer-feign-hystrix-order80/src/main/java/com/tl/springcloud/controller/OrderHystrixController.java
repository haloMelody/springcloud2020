package com.tl.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.tl.springcloud.service.PaymentHystrixService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <pre>
 * Description
 * @author T-Dragon
 * 2020/4/30 16:31
 * </pre>
 */
@RestController
@Slf4j
@DefaultProperties(defaultFallback = "paymentGlobalFallback")
public class OrderHystrixController {

	@Resource
	private PaymentHystrixService paymentHystrixService;

	@GetMapping("/consumer/payment/hystrix/ok/{id}")
	public String paymentInfoOk(@PathVariable("id") Integer id){
		return paymentHystrixService.paymentInfoOk(id);
	}

	/**
	 * 定制降级方法
	 * 未指定则使用全局方法
	 * 未使用注解则不进行服务降级
	 * @param id
	 * @return
	 */
	// @HystrixCommand(fallbackMethod = "paymentInfoTimeoutHandler" , commandProperties = {
	// 		@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1500")
	// })
	@HystrixCommand
	@GetMapping("/consumer/payment/hystrix/timeout/{id}")
	public String paymentInfoTimeout(@PathVariable("id") Integer id){
		int a = 10 / 0;
		return paymentHystrixService.paymentInfoTimeout(id);
	}
	public String paymentInfoTimeoutHandler(@PathVariable("id") Integer id){
		return "order 80 , server is error , sorry";
	}

	/**
	 * 全局fallback
	 * @return
	 */
	public String paymentGlobalFallback() {
		return "Global异常处理信息,请稍后重试.o(╥﹏╥)o";
	}


}
