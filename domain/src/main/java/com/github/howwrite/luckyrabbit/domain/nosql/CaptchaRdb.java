package com.github.howwrite.luckyrabbit.domain.nosql;

import lombok.RequiredArgsConstructor;
import org.redisson.api.RBucket;
import org.redisson.api.RedissonClient;
import org.springframework.stereotype.Repository;

import java.util.concurrent.TimeUnit;

@RequiredArgsConstructor
@Repository
public class CaptchaRdb {
    public static final String captchaDbName = "lucky_rabbit_captcha:";
    private final RedissonClient redissonClient;

    public boolean bindCaptcha(String sessionId, String token, String captchaBody, long minuteToLive) {
        RBucket<Object> bucket = redissonClient.getBucket(captchaDbName + sessionId + token);
        bucket.set(captchaBody, minuteToLive, TimeUnit.MINUTES);
        return true;
    }
}
