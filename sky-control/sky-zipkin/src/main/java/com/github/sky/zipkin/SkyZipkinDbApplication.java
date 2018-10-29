package com.github.sky.zipkin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import zipkin.server.EnableZipkinServer;

/**
 * @Auther: haoxin
 * @Date: 2018-10-23 11:28
 * @Description:zipkin监控服务
 */
@EnableDiscoveryClient
@SpringBootApplication
@EnableZipkinServer
public class SkyZipkinDbApplication {
    public static void main(String[] args) {
        SpringApplication.run(SkyZipkinDbApplication.class, args);
    }

}
