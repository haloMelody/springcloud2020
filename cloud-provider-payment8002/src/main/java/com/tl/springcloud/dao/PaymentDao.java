package com.tl.springcloud.dao;

import com.tl.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.Mapping;

/**
 * <pre>
 * Description
 * @author T-Dragon
 * 2020/4/16 13:54
 * </pre>
 */
@Mapper
public interface PaymentDao {

	public int create(Payment payment);

	public Payment getPaymentById(@Param("id") Long id);
}
