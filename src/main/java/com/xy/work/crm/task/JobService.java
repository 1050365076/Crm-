package com.xy.work.crm.task;


import com.xy.work.crm.service.CustomerService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.SimpleFormatter;

/**
 * 系统定时任务
 */
@Service
public class JobService {
    @Resource
    private CustomerService customerService;

    @Scheduled(cron = "0 0 17 1 1-12 ? ")
    public void job(){
        System.out.println("定时任务开始执行--------"+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        customerService.updateCustomerState();
    }
}
