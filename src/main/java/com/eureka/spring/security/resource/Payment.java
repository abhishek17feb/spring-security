package com.eureka.spring.security.resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Payment {

    @GetMapping("/pay")
    public String payDues(){return "User Payment Done";}
}
