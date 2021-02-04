package com.example.calculator.impl;

import com.example.calculator.ExchangeCalculatorService;
import com.example.calculator.ExchangeRequest;
import com.example.calculator.annotations.RSocketHandler;
import com.example.calculator.annotations.RSocketService;
import reactor.core.publisher.Mono;

@RSocketService("com.example.calculator.ExchangeCalculatorService")
public class ExchangeCalculatorImpl implements ExchangeCalculatorService {
    @Override
    @RSocketHandler("exchange")
    public Mono<Double> exchange(ExchangeRequest request) {
        if (request.getSource().equals("USD") && request.getTarget().equals("CNY")) {
            return Mono.just(request.getAmount() * 6.4);
        }
        return Mono.just(0.0);
    }
}
