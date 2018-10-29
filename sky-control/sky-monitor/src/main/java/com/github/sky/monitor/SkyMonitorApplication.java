package com.github.sky.monitor;

import de.codecentric.boot.admin.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

/**
 * @Auther: haoxin
 * @Date: 2018-10-23 11:22
 * @Description:监控服务
 */
@EnableAdminServer
@EnableTurbine
@EnableDiscoveryClient
@SpringCloudApplication
public class SkyMonitorApplication {
    public static void main(String[] args) {
        SpringApplication.run(SkyMonitorApplication.class, args);
    }

}
