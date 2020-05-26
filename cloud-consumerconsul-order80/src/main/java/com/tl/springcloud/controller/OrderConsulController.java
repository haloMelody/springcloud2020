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
public class OrderConsulController {

	public static final String INVOKE_URL = "http://cloud-provider-payment";
	@Resource
	private RestTemplate restTemplate;


	/**
	 * http://localhost/consumer/payment/consul
	 *
	 * @return
	 */
	@GetMapping("/consumer/payment/consul")
	public String paymentInfo() {
		return restTemplate.getForObject(INVOKE_URL + "/payment/consul", String.class);
	}
}
