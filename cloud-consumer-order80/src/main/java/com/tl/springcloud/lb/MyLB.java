package com.tl.springcloud.lb;

import cn.hutool.core.collection.CollectionUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * <pre>
 * Description
 * @author T-Dragon
 * 2020/4/28 14:55
 * </pre>
 */
@Component
@Slf4j
public class MyLB implements LoadBalancer {

	private AtomicInteger current = new AtomicInteger(0);

	@Override
	public ServiceInstance instances(List<ServiceInstance> serviceInstances) {

		if (CollectionUtil.isEmpty(serviceInstances)) {
			return null;
		}

		// 访问次数 % 集合数量
		int current = getIndexAndIncrement();
		log.info("*******第几次访问：" + current);
		int index = current % serviceInstances.size();

		return serviceInstances.get(index);
	}

	private int getIndexAndIncrement() {

		for (; ; ) {
			int current = this.current.get();

			int next = current > 10 ? 0 : current + 1;

			if (this.current.compareAndSet(current, next)) {
				return next;
			}
		}

	}
}
