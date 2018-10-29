package com.github.sky.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @Auther: haoxin
 * @Date: 2018-10-23 11:16
 * @Description:配置服务
 */
@EnableDiscoveryClient
@EnableConfigServer
@SpringBootApplication
public class SkyConfigApplication {
    public static void main(String[] args) {
        SpringApplication.run(SkyConfigApplication.class, args);
    }

}
