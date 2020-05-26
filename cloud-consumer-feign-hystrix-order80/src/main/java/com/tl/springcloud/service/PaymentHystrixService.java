package com.tl.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * <pre>
 * Description FeignClient + Hystrix
 * 接口层统一做降级处理
 * @author T-Dragon
 * 2020/4/30 16:29
 * </pre>
 */
@Component
@FeignClient(value = "cloud-payment-hystrix-service" , fallback = PaymentFallbackService.class)
public interface PaymentHystrixService {


	@GetMapping("/payment/hystrix/ok/{id}")
	public String paymentInfoOk(@PathVariable("id") Integer id);

	@GetMapping("/payment/hystrix/timeout/{id}")
	public String paymentInfoTimeout(@PathVariable("id") Integer id);

}
