package com.github.sky.common.util.lock;

import org.redisson.api.RLock;

import java.util.concurrent.TimeUnit;

/**
 * @Auther: haoxin
 * @Date: 2018-10-16 11:08
 * @Description:分布式锁接口
 */
public interface DistributedLocker {

    RLock lock(String lockKey);

    RLock lock(String lockKey, long timeout);

    RLock lock(String lockKey, TimeUnit unit, long timeout);

    boolean tryLock(String lockKey, TimeUnit unit, long waitTime, long leaseTime);

    void unlock(String lockKey);

    void unlock(RLock lock);
}
