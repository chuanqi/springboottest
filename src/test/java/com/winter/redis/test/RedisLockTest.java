package com.winter.redis.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * @Description:
 * @author: xu
 * @Date: 2019-08-24
 * @Time: 22:21
 */
@RunWith(SpringJUnit4ClassRunner.class)
@EnableAutoConfiguration
public class RedisLockTest {
    @Autowired
    RedisTemplate redisTemplate;
    /**
     * 加锁键名
     */
    String lockKey = "lockKey";

    /**
     * 使用自增获取锁
     */
    @Test
    public void redisLock1() {
        //如果等于1时,说明获取到了锁,大于1时说明锁还被别的线程占用
        if (1 == incr(lockKey, 1)) {
            doSomething();
            //执行完成删除这个键(释放锁)
            redisTemplate.delete(lockKey);
        }
    }

    /**
     * 做一些业务执行的操作
     */
    private void doSomething() {

        System.out.println("业务执行代码开始");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("业务执行代码结束");
    }

    /**
     * 递增
     *
     * @param key   键
     * @param delta 要增加几(大于0)
     * @return
     */
    public long incr(String key, long delta) {
        if (delta < 0) {
            throw new RuntimeException("递增因子必须大于0");
        }
        return redisTemplate.opsForValue().increment(key, delta);
    }
}

