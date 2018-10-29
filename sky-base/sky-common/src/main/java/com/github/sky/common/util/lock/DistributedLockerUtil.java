package com.github.sky.common.util.lock;

import com.github.sky.common.util.SpringContextHolder;
import org.redisson.api.RLock;

import java.util.concurrent.TimeUnit;

/**
 * @Auther: haoxin
 * @Date: 2018-10-17 13:25
 * @Description:分布式锁工具类
 */
public class DistributedLockerUtil {

    private static DistributedLocker distributedLocker = SpringContextHolder.getBean(RedissonDistributedLocker.class);

    public static DistributedLocker getInstance(){
        return distributedLocker;
    }


    /**
     * 加锁，拿不到lock就不罢休，不然线程就一直block
     * @param lockKey key
     * @return
     */
    public static RLock lock(String lockKey) {
        return distributedLocker.lock(lockKey);
    }

    /**
     *加锁，超时自动释放
     * @param lockKey key
     * @param leaseTime  加锁时间，单位为秒
     * @return
     */
    public static RLock lock(String lockKey, long leaseTime) {
        return distributedLocker.lock(lockKey,leaseTime);
    }

    /**
     * 加锁，超时自动释放
     * @param lockKey key
     * @param unit 时间单位
     * @param timeout 超时时间
     * @return
     */
    public static RLock lock(String lockKey, TimeUnit unit , long timeout) {
        return distributedLocker.lock(lockKey,unit,timeout);
    }

    /**
     * tryLock()，马上返回，拿到lock就返回true，不然返回false。带时间限制的tryLock()，拿不到lock，就等一段时间，超时返回false.
     * @param lockKey key
     * @param unit 时间单位
     * @param waitTime 等待时间，等待时间到了立即返回
     * @param leaseTime 释放锁的时间
     * @return
     */
    public static boolean tryLock(String lockKey, TimeUnit unit, long waitTime, long leaseTime) {
        return distributedLocker.tryLock(lockKey,unit,waitTime,leaseTime);
    }

    /**
     * 释放锁
     * @param lockKey key
     */
    public static void unlock(String lockKey) {
        distributedLocker.unlock(lockKey);
    }

    /**
     * 释放锁
     * @param lock 锁
     */
    public static void unlock(RLock lock) {
        distributedLocker.unlock(lock);
    }
}
