package com.github.sky.elasticJob;

import com.cxytiandi.elasticjob.annotation.EnableElasticJob;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.util.concurrent.CountDownLatch;

/**
 * @Auther: haoxin
 * @Date: 2018-10-31 10:49
 * @Description:分布式事务
 */
@SpringBootApplication
@EnableElasticJob
@ComponentScan(basePackages = {"com.github.sky"})
public class SkyElasticJobServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(SkyElasticJobServerApplication.class, args);
    }

}
