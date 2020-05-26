package com.tl.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * <pre>
 * Description
 * @author T-Dragon
 * 2020/4/19 16:12
 * </pre>
 */
@RestController
@Slf4j
public class OrderZkController {

	public static final String INVOKE_URL = "http://cloud-payment-service";
	@Resource
	private RestTemplate restTemplate;


	/**
	 * http://localhost/consumer/payment/zk
	 *
	 * @return
	 */
	@GetMapping("/consumer/payment/zk")
	public String paymentInfo() {
		return restTemplate.getForObject(INVOKE_URL + "/payment/zk", String.class);
	}
}
