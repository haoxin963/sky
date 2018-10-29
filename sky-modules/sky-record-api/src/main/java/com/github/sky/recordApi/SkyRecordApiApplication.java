package com.github.sky.recordApi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * @Auther: haoxin
 * @Date: 2018-10-25 19:28
 * @Description:接口服务类
 */
@EnableAsync
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@ComponentScan(basePackages = {"com.github.sky"})
public class SkyRecordApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(SkyRecordApiApplication.class, args);
    }

}
