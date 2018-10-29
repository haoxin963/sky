package com.github.sky.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * @Auther: haoxin
 * @Date: 2018-10-24 15:35
 * @Description:统一认证服务
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@ComponentScan(basePackages = {"com.github.sky"})
public class SkyAuthServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(SkyAuthServerApplication.class, args);
    }

}
