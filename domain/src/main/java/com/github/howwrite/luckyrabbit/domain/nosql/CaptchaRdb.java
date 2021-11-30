package com.github.howwrite.luckyrabbit.domain.nosql;

import com.github.howwrite.treasure.common.exception.ServerBizException;
import lombok.RequiredArgsConstructor;
import org.redisson.api.RBucket;
import org.redisson.api.RedissonClient;
import org.springframework.stereotype.Repository;

import java.util.concurrent.TimeUnit;

@RequiredArgsConstructor
@Repository
public class CaptchaRdb {
    public static final String CAPTCHA_DB_NAME = "lucky_rabbit_captcha:";
    private final RedissonClient redissonClient;

    public boolean bindCaptcha(String sessionId, String token, String captchaBody, long minuteToLive) {
        RBucket<String> bucket = redissonClient.getBucket(CAPTCHA_DB_NAME + sessionId + token);
        bucket.set(captchaBody, minuteToLive, TimeUnit.MINUTES);
        return true;
    }

    public boolean verifyCaptcha(String sessionId, String token, String captcha) {
        RBucket<String> bucket = redissonClient.getBucket(CAPTCHA_DB_NAME + sessionId + token);
        String realCaptcha = bucket.get();
        if (realCaptcha == null || !realCaptcha.equals(captcha)) {
            throw new ServerBizException("验证码错误，请重试或者更新验证码");
        }
        return bucket.delete();
    }
}
