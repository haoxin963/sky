package com.github.sky.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @Auther: haoxin
 * @Date: 2018-10-23 10:21
 * @Description:注册发现服务
 */
@EnableEurekaServer
@SpringBootApplication
public class SkyEurekaApplication {
    public static void main(String[] args) {
        SpringApplication.run(SkyEurekaApplication.class, args);
    }
}
