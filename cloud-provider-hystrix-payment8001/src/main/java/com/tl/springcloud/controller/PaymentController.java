package com.tl.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.tl.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <pre>
 * Description
 * @author T-Dragon
 * 2020/4/30 15:56
 * </pre>
 */
@RestController
@Slf4j
public class PaymentController {

	@Resource
	private PaymentService paymentService;

	@Value("${server.port}")
	private String serverPort;

	@GetMapping("/payment/hystrix/ok/{id}")
	public String paymentInfoOk(@PathVariable("id") Integer id) {
		String result = paymentService.paymentInfoOk(id);
		log.info(result);
		return result;
	}

	@GetMapping("/payment/hystrix/timeout/{id}")
	public String paymentInfoTimeout(@PathVariable("id") Integer id) {
		String result = paymentService.paymentInfoTimeout(id);
		log.info(result);
		return result;
	}

	/**
	 * 服务熔断test
	 * @param id
	 * @return
	 */
	@GetMapping("/payment/hystrix/circuit/{id}")
	public String paymentCircuitBreaker(@PathVariable("id") Integer id) {
		String result = paymentService.paymentCircuitBreaker(id);
		log.info(result);
		return result;
	}

}
