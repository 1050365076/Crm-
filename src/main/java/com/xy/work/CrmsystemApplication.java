package com.xy.work;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;


@SpringBootApplication
@MapperScan("com.xy.work.crm.dao")
@EnableScheduling //启用定时任务注解
public class CrmsystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(CrmsystemApplication.class, args);
    }

}
