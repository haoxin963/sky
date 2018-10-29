package com.github.sky.recordService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @Auther: haoxin
 * @Date: 2018-10-26 11:15
 * @Description:上传记录
 */
@EnableAsync
@SpringBootApplication
@EnableDiscoveryClient
@EnableTransactionManagement
@ComponentScan(basePackages = {"com.github.sky"})
public class SkyRecordServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(SkyRecordServiceApplication.class, args);
    }
}
