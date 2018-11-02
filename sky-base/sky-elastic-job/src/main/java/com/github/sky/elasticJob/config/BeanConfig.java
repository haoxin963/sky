package com.github.sky.elasticJob.config;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * @Auther: haoxin
 * @Date: 2018-11-2 17:10
 * @Description:
 */
@Configuration
public class BeanConfig {

    /**
     * 任务执行事件数据源
     * @return
     */
    @Bean("datasource")
    @ConfigurationProperties("spring.datasource.druid.log")
    public DataSource dataSourceTwo(){
        return DruidDataSourceBuilder.create().build();
    }

}
