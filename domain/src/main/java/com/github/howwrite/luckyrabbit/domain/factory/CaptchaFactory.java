package com.github.howwrite.luckyrabbit.domain.factory;

import cn.hutool.core.util.RandomUtil;
import com.github.howwrite.luckyrabbit.domain.model.Captcha;
import com.github.howwrite.luckyrabbit.domain.valueobject.Session;
import com.github.howwrite.luckyrabbit.tools.config.LuckyRabbitConfig;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class CaptchaFactory {
    private final LuckyRabbitConfig luckyrabbitConfig;

    public Captcha generateRandomCaptcha(Session session) {
        // 生成captchaBody
        String captchaBody = RandomUtil.randomString(luckyrabbitConfig.getCaptchaBodyLength());
        // 生成token
        String captchaToken = RandomUtil.randomString(32);
        return new Captcha(captchaToken, captchaBody, luckyrabbitConfig.getCaptchaLiveMinute(), session);
    }
}
