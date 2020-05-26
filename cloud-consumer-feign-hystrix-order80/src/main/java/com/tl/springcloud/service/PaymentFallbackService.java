package com.tl.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * <pre>
 * Description
 * @author T-Dragon
 * 2020/5/6 10:11
 * </pre>
 */
@Component
public class PaymentFallbackService implements PaymentHystrixService {
	@Override
	public String paymentInfoOk(Integer id) {
		return "PaymentFallbackService.paymentInfoOk:error";
	}

	@Override
	public String paymentInfoTimeout(Integer id) {
		return "PaymentFallbackService.paymentInfoTimeout:error";
	}
}
