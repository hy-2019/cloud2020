package com.atguigu.springcloud.service;

import com.atguigu.springcloud.repository.domain.PaymentDomain;

import java.util.List;

public interface PaymentService {
    Integer create(PaymentDomain paymentDomain);

    List<PaymentDomain> query();

    PaymentDomain getById(Long id);
}
