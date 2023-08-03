package com.study.payroll.service;

import com.study.payroll.entity.Payment;
import com.study.payroll.entity.Worker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@Service
public class PaymentService {

    @Value("${worker.host}")
    private String workerHost;

    @Autowired
    private RestTemplate restTemplate;

    public Payment getPayment(Long workerId, Integer workedDays){
        Map<String, String> uriMap = new HashMap<String, String>();
        uriMap.put("workerId", String.valueOf(workerId));
        Worker worker = restTemplate.getForObject(workerHost + "/workers/{workerId}", Worker.class, uriMap);
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
