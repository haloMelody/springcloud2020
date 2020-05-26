package com.tl.springcloud.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * <pre>
 * Description
 * @author T-Dragon
 * 2020/4/30 15:51
 * </pre>
 */
@Service
public class PaymentService {

	public String paymentInfoOk(Integer id) {
		return "thread pool: " + Thread.currentThread().getName() + " paymentInfoOk ,id:" + id;
	}

	/**
	 * 服务降级HystrixCommand
	 * 定义超时时间为3S，不超过正常执行，超过则执行fallback方法
	 * 如果程序执行异常，也会执行fallback方法
	 * @param id
	 * @return
	 */
	@HystrixCommand(fallbackMethod = "paymentInfoTimeoutHandler", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "5000")
	})
	public String paymentInfoTimeout(Integer id) {
		int times = 3;
		try {
			TimeUnit.SECONDS.sleep(times);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		// int a = 10/0;
		return "thread pool: " + Thread.currentThread().getName() + " paymentInfoTimeout ,id:" + id ;
	}

	public String paymentInfoTimeoutHandler(Integer id) {
		return "thread pool: " + Thread.currentThread().getName() + " 8001系统繁忙，请稍后再试！ ,id:" + id + "/(ㄒoㄒ)/~~";
	}


	/**
	 * 服务熔断
	 * 参数含义（熔断流程）：
	 * 开启断路器后，在时间窗口期内（10S，用于确定统计请求和数据的时间间隔），
	 * 10次请求（请求次数必须达到这个值）中超过60%是失败的，
	 * 则开启熔断（CLOSED-OPEN），所有请求均失败,调用fallback，
	 * 等待一定时间后（5S），接下来的请求会进入半开状态，
	 * 如果请求成功，则重新恢复服务调用（CLOSED）
	 * 如果请求失败，则继续熔断（OPEN）
	 * @param id
	 * @return
	 */
	@HystrixCommand(fallbackMethod = "paymentCircuitBreakerFallback", commandProperties = {
			@HystrixProperty(name="circuitBreaker.enabled" , value = "true"),//是否开启断路器
			@HystrixProperty(name="circuitBreaker.requestVolumeThreshold" , value = "10"),//请求次数阈值
			@HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"),//时间窗口期
			@HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60")//失败的百分比
	})
	public String paymentCircuitBreaker(Integer id) {
		if (id < 0) {
			throw new RuntimeException("error : id less than 0");
		}
		String s = IdUtil.simpleUUID();
		return "thread pool: " + Thread.currentThread().getName() + " success ,number = " + s;
	}
	public String paymentCircuitBreakerFallback(Integer id) {
		return "id can't less than 0 , please try again , id = " + id;
	}

}
