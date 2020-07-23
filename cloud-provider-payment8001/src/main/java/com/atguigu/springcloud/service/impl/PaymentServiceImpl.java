package com.atguigu.springcloud.service.impl;

import com.atguigu.springcloud.repository.dao.PaymentDao;
import com.atguigu.springcloud.service.PaymentService;
import com.atguigu.springcloud.repository.domain.PaymentDomain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName PaymentServiceImpl
 * @Description TODO
 * @Author 黄毅
 * @Date 2020/7/18 10:31
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    private PaymentDao paymentDao;

    @Autowired
    public PaymentServiceImpl(PaymentDao paymentDao) {
        this.paymentDao = paymentDao;
    }

    @Override
    public Integer create(PaymentDomain paymentDomain) {
        return paymentDao.insert(paymentDomain);
    }

    @Override
    public List<PaymentDomain> query() {
        return paymentDao.queryAll();
    }

    @Override
    public PaymentDomain getById(Long id) {
        return paymentDao.queryById(id);
    }
}
