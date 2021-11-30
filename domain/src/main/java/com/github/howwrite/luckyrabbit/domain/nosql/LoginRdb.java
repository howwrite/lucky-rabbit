package com.github.howwrite.luckyrabbit.domain.nosql;

import lombok.RequiredArgsConstructor;
import org.redisson.api.RBucket;
import org.redisson.api.RedissonClient;
import org.springframework.stereotype.Repository;

import java.util.concurrent.TimeUnit;

/**
 * @author howwrite
 * @date 2021/11/27
 */

@RequiredArgsConstructor
@Repository
public class LoginRdb {

    public static final String LOGIN_DB_NAME = "lucky_rabbit_login:";
    private final RedissonClient redissonClient;

    public Long findUserIdByToken(String token) {
        RBucket<Long> bucket = redissonClient.getBucket(LOGIN_DB_NAME + token);
        return bucket.get();
    }

    public boolean bindLoginToken(String token, Long userId, int hourToLive) {
        RBucket<Long> bucket = redissonClient.getBucket(LOGIN_DB_NAME + token);
        bucket.set(userId, hourToLive, TimeUnit.HOURS);
        return true;
    }
}
