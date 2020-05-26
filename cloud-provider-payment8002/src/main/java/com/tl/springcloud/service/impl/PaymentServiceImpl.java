package com.tl.springcloud.service.impl;

import com.tl.springcloud.dao.PaymentDao;
import com.tl.springcloud.entities.Payment;
import com.tl.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <pre>
 * Description
 * @author T-Dragon
 * 2020/4/16 14:10
 * </pre>
 */
@Service
public class PaymentServiceImpl implements PaymentService {

	@Resource
	private PaymentDao paymentDao;

	@Override
	public int create(Payment payment) {
		return paymentDao.create(payment);
	}

	@Override
	public Payment getPaymentById(Long id) {
		return paymentDao.getPaymentById(id);
	}
}
