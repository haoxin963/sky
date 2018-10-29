package com.github.sky.rbac;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * @Auther: haoxin
 * @Date: 2018-10-25 15:29
 * @Description:用户角色权限服务
 */
@EnableAsync
@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan(basePackages = {"com.github.sky"})
public class SkyRbacApplication {
    public static void main(String[] args) {
        SpringApplication.run(SkyRbacApplication.class, args);
    }
}
