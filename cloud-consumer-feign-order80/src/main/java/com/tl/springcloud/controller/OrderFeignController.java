package com.tl.springcloud.controller;

import com.tl.springcloud.entities.CommonResult;
import com.tl.springcloud.entities.Payment;
import com.tl.springcloud.service.PaymentFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <pre>
 * Description
 * @author T-Dragon
 * 2020/4/28 17:02
 * </pre>
 */
@RestController
@Slf4j
public class OrderFeignController {

	@Resource
	private PaymentFeignService paymentFeignService;

	@GetMapping("/consumer/payment/get/{id}")
	public CommonResult getPaymentById(@PathVariable("id") Long id) {
		return paymentFeignService.getPaymentById(id);
	}

	@GetMapping("/consumer/payment/feign/timeout")
	public String getFeignPaymentTimeout() {
		// 消费端默认等待1S
		return paymentFeignService.getFeignPaymentTimeout();
	}

}
