package com.xy.work;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@MapperScan("com.xy.work.crm.dao")
public class CrmsystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(CrmsystemApplication.class, args);
    }

}
