package com.tl.murule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * <pre>
 * Description 修改ribbon的轮询算法，此路径不能位于@componentScan的扫描下
 * @author T-Dragon
 * 2020/4/28 14:13
 * </pre>
 */
@Configuration
public class MyRule {

	@Bean
	public IRule mySelfRule(){
		return new RandomRule();
	}

}
