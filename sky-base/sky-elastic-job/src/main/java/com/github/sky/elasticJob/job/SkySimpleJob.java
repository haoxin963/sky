package com.github.sky.elasticJob.job;

import com.cxytiandi.elasticjob.annotation.ElasticJobConf;
import com.dangdang.ddframe.job.api.ShardingContext;
import com.dangdang.ddframe.job.api.simple.SimpleJob;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Auther: haoxin
 * @Date: 2018-11-2 16:12
 * @Description:demo
 */
@ElasticJobConf(name = "SkySimpleJob", cron = "0/10 * * * * ?",
        shardingItemParameters = "0=0,1=1", description = "简单任务", eventTraceRdbDataSource = "datasource")
public class SkySimpleJob  implements SimpleJob {
    public void execute(ShardingContext context) {
        System.out.println(2/0);
        String shardParamter = context.getShardingParameter();
        System.out.println("分片参数："+shardParamter);
        int value = Integer.parseInt(shardParamter);
        for (int i = 0; i < 1000000; i++) {
            if (i % 2 == value) {
                String time = new SimpleDateFormat("HH:mm:ss").format(new Date());
                System.out.println(time + ":开始执行简单任务" + i);
            }
        }
    }
}
