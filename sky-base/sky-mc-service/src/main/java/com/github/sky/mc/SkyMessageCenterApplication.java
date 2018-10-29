package com.github.sky.mc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Auther: haoxin
 * @Date: 2018-10-24 15:40
 * @Description:消息中心
 */
@EnableDiscoveryClient
@SpringBootApplication
public class SkyMessageCenterApplication {
    public static void main(String[] args) {
        SpringApplication.run(SkyMessageCenterApplication.class, args);
    }

}
