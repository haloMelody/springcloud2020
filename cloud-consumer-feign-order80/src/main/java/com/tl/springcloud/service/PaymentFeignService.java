package com.tl.springcloud.service;

import com.tl.springcloud.entities.CommonResult;
import com.tl.springcloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * <pre>
 * Description
 * @author T-Dragon
 * 2020/4/28 17:00
 * </pre>
 */
@Component
@FeignClient("cloud-payment-service")
public interface PaymentFeignService {

	@GetMapping("/payment/get/{id}")
	CommonResult<Payment> getPaymentById(@PathVariable("id") Long id);

	@GetMapping("/payment/feign/timeout")
	String getFeignPaymentTimeout();

}
