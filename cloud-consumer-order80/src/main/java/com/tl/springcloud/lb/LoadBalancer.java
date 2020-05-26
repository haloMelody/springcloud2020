package com.tl.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * <pre>
 * Description 自定义负载均衡算法 接口
 * @author T-Dragon
 * 2020/4/28 14:53
 * </pre>
 */
public interface LoadBalancer {

	/**
	 * 从给定的服务集合中，按照一定的算法选择一个服务返回
	 * @param serviceInstances
	 * @return
	 */
	ServiceInstance instances(List<ServiceInstance> serviceInstances);

}
