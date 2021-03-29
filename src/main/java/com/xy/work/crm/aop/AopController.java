package com.xy.work.crm.aop;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/aopController")
public class AopController {

    @RequestMapping("/sayHello")
    public String sayHello(String name){
        return "hello"+name;
    }
}
