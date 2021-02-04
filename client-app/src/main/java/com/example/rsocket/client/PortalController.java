package com.example.rsocket.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.rsocket.RSocketRequester;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class PortalController {
    @Autowired
    private RSocketRequester mathCalculatorRequester;

    @GetMapping("/square/{number}")
    public Mono<String> index(@PathVariable("number") int number) {
        return mathCalculatorRequester.route("com.example.calculator.MathCalculatorService.square")
                .data(number)
                .retrieveMono(Integer.class)
                .map(result -> number + "*" + number + "=" + result);
    }
}
