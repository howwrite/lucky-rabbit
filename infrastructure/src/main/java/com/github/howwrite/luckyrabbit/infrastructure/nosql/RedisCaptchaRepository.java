package com.github.howwrite.luckyrabbit.infrastructure.nosql;

import com.github.howwrite.luckyrabbit.domain.model.Captcha;
import com.github.howwrite.luckyrabbit.domain.repository.CaptchaRepository;
import com.github.howwrite.treasure.common.exception.ServerBizException;
import lombok.RequiredArgsConstructor;
import org.redisson.api.RBucket;
import org.redisson.api.RedissonClient;
import org.springframework.stereotype.Repository;

import java.util.concurrent.TimeUnit;

@RequiredArgsConstructor
@Repository
public class RedisCaptchaRepository implements CaptchaRepository {
    public static final String CAPTCHA_DB_NAME = "lucky_rabbit_captcha:";
    private final RedissonClient redissonClient;

    @Override
    public boolean bindCaptcha(Captcha captcha) {
        RBucket<String> bucket = redissonClient.getBucket(CAPTCHA_DB_NAME + captcha.getSession().getSessionId() + captcha.getCaptchaToken());
        bucket.set(captcha.getCaptchaBody(), captcha.getMinuteToLive(), TimeUnit.MINUTES);
        return true;
    }

    @Override
    public boolean verifyCaptcha(Captcha captcha) {
        RBucket<String> bucket = redissonClient.getBucket(CAPTCHA_DB_NAME + captcha.getSession().getSessionId() + captcha.getCaptchaToken());
        String realCaptcha = bucket.get();
        if (realCaptcha == null || !realCaptcha.equals(captcha.getCaptchaBody())) {
            throw new ServerBizException("验证码错误，请重试或者更新验证码");
        }
        return bucket.delete();
    }
}
