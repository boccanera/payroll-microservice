package com.study.payroll.entity;

import java.math.BigDecimal;

public class Payment {
    private String name;
    private BigDecimal dailyIncome;
    private Integer days;

    public Payment(){}

    public Payment(String name, BigDecimal dailyIncome, Integer days) {
        this.name = name;
        this.dailyIncome = dailyIncome;
        this.days = days;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getDailyIncome() {
        return dailyIncome;
    }

    public Integer getDays() {
        return days;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDailyIncome(BigDecimal dailyIncome) {
        this.dailyIncome = dailyIncome;
    }

    public void setDays(Integer days) {
        this.days = days;
    }

    public BigDecimal getTotalPayment() {
        return dailyIncome.multiply(BigDecimal.valueOf(days));
    }
}
