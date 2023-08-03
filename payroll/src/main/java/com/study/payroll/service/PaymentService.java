package com.study.payroll.service;

import com.study.payroll.entity.Payment;
import com.study.payroll.entity.Worker;
import com.study.payroll.feign.WorkerFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@Service
public class PaymentService {

    @Autowired
    private WorkerFeignClient workerFeignClient;

    public Payment getPayment(Long workerId, Integer workedDays){
        Worker worker = workerFeignClient.findById(workerId).getBody();
        return new Payment(worker.getName(), worker.getDailyIncome(), workedDays);
    }

    /* OR USE WEBCLIENT

        public PaymentService(WebClient.Builder webClientBuilder) {
        this.webClientBuilder = webClientBuilder;
    }

    public Mono<Payment> getPayment(Long workerId, Integer workedDays) {
        return webClientBuilder
                .baseUrl(workerHost) // Assuming workerHost is already set as the base URL
                .build()
                .get()
                .uri("/workers/{workerId}", workerId)
                .retrieve()
                .bodyToMono(Worker.class)
                .map(worker -> new Payment(worker.getName(), worker.getDailyIncome(), workedDays));
    }
     */



}
