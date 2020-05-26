package com.tl.springcloud.controller;

import com.tl.springcloud.entities.CommonResult;
import com.tl.springcloud.entities.Payment;
import com.tl.springcloud.lb.LoadBalancer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;

/**
 * <pre>
 * Description
 * @author T-Dragon
 * 2020/4/16 15:17
 * </pre>
 */
@RestController
@Slf4j
public class OrderController {

	//单机写死地址
	// public static final String PAYMENT_URL = "http://localhost:8001";
	//集群通过eureka集群服务名
	public static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";

	@Resource
	private RestTemplate restTemplate;

	@Resource
	private LoadBalancer loadBalancer;

	@Resource
	private DiscoveryClient discoveryClient;

	@GetMapping("/consumer/payment/create")
	public CommonResult create(Payment payment) {
		return restTemplate.postForObject(PAYMENT_URL + "/payment/create", payment, CommonResult.class);
	}

	@GetMapping("/consumer/payment/createForEntity")
	public CommonResult createForEntity(Payment payment) {
		ResponseEntity<CommonResult> responseEntity = restTemplate.postForEntity(PAYMENT_URL + "/payment/create", payment, CommonResult.class);
		if (responseEntity.getStatusCode().is2xxSuccessful()) {
			return responseEntity.getBody();
		}else{
			return new CommonResult(444, "查询失败");
		}
	}

	@GetMapping("/consumer/payment/get/{id}")
	public CommonResult getPayment(@PathVariable("id") Long id) {
		return restTemplate.getForObject(PAYMENT_URL + "/payment/get/" + id, CommonResult.class);
	}

	@GetMapping("/consumer/payment/getForEntity/{id}")
	public CommonResult getPaymentForEntity(@PathVariable("id") Long id) {
		ResponseEntity<CommonResult> entity = restTemplate.getForEntity(PAYMENT_URL + "/payment/get/" + id, CommonResult.class);
		if (entity.getStatusCode().is2xxSuccessful()) {
			return entity.getBody();
		}else{
			return new CommonResult(444, "查询失败");
		}
	}

	@GetMapping("/consumer/payment/lb")
	public String getLb(){
		List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
		ServiceInstance serviceInstance = loadBalancer.instances(instances);
		return restTemplate.getForObject(serviceInstance.getUri() + "/payment/lb", String.class);
	}

}
