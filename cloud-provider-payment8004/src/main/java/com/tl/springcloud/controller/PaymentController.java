package com.tl.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * <pre>
 * Description
 * @author T-Dragon
 * 2020/4/19 15:19
 * </pre>
 */
@RestController
@RequestMapping("/payment")
public class PaymentController {

	@Resource
	private DiscoveryClient discoveryClient;

	@Value("${server.port}")
	private String serverPort;

	@RequestMapping("/zk")
	public String paymentZk() {
		return "SpringCloud with zookeeper:" + serverPort + "\t" + UUID.randomUUID().toString();
	}

}
