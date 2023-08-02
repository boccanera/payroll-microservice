package com.study.payroll.service;

import com.study.payroll.entity.Payment;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class PaymentService {

    public Payment getPayment(Long id, Integer workedDays){
        BigDecimal dailyIncome = new BigDecimal("200.0065");
        return new Payment("Bob", dailyIncome, workedDays);
    }

}
