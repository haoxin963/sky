package com.github.sky.common.util.lock;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.redisson.config.SingleServerConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Auther: haoxin
 * @Date: 2018-10-16 10:57
 * @Description:分布式锁 redisson配置
 */

@Configuration
public class RedissonManager {
    @Value("${spring.redis.host}")
    private  String host;
    @Value("${spring.redis.port}")
    private String port;
    @Value("${spring.redis.password}")
    private String password;

    @Bean
    public RedissonClient getRedisson(){
        String address = "redis://"+host+":"+port;
        Config config = new Config();
        SingleServerConfig serverConfig = config.useSingleServer()
                .setAddress(address)
                .setPassword(password)
                .setTimeout(30000)
                .setConnectionPoolSize(64)
                .setConnectionMinimumIdleSize(10);
        return Redisson.create(config);
    }

}
