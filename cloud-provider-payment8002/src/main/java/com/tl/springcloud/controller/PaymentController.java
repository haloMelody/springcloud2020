package com.tl.springcloud.controller;

import com.sun.org.apache.regexp.internal.RE;
import com.tl.springcloud.entities.CommonResult;
import com.tl.springcloud.entities.Payment;
import com.tl.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * <pre>
 * Description
 * @author T-Dragon
 * 2020/4/16 14:14
 * </pre>
 */
@Slf4j
@RestController
@RequestMapping("/payment")
public class PaymentController {

	@Resource
	private PaymentService paymentService;

	@Resource
	private DiscoveryClient discoveryClient;

	@Value("${server.port}")
	private String serverPort;

	@PostMapping("/create")
	public CommonResult<Integer> create(@RequestBody Payment payment){
		int id = paymentService.create(payment);
		if (id > 0) {
			return new CommonResult<>(200, "create success", id);
		}else{
			return new CommonResult<>(400, "create fail", null);
		}
	}

	@GetMapping("/get/{id}")
	public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){
		Payment payment = paymentService.getPaymentById(id);
		if (payment != null) {

			return new CommonResult<>(200, "query success , server port:" + serverPort, payment);
		}else{
			return new CommonResult<>(400, "query fail:" + serverPort, null);
		}
	}

	/**
	 * 服务发现
	 * @return
	 */
	@GetMapping("/discovery")
	public Object discovery() {

		List<String> services = discoveryClient.getServices();

		for (String service : services) {
			log.info("discoveryClient service:{}" , service);
		}

		List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
		for (ServiceInstance instance : instances) {
			log.info("discoveryClient instance:{}" , instance.getServiceId()+"\t"+instance.getHost()+"\t"+instance.getPort()+"\t"+instance.getUri());
		}

		return discoveryClient;

	}

	@GetMapping("/lb")
	public String getLb(){
		return serverPort;
	}

	@GetMapping("/feign/timeout")
	public String getFeignPaymentTimeout(){
		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return serverPort;
	}
}
