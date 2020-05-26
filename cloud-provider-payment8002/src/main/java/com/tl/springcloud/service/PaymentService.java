package com.tl.springcloud.service;

import com.tl.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * <pre>
 * Description
 * @author T-Dragon
 * 2020/4/16 14:10
 * </pre>
 */
public interface PaymentService {

	int create(Payment payment);

	Payment getPaymentById(Long id);

}
