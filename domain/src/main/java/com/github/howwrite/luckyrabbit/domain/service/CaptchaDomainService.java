package com.github.howwrite.luckyrabbit.domain.service;

import com.github.howwrite.luckyrabbit.domain.factory.CaptchaFactory;
import com.github.howwrite.luckyrabbit.domain.model.Captcha;
import com.github.howwrite.luckyrabbit.domain.repository.CaptchaRepository;
import com.github.howwrite.luckyrabbit.domain.valueobject.Session;
import com.github.howwrite.treasure.common.exception.ServerBizException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CaptchaDomainService {
    private final CaptchaRepository captchaRepository;
    private final CaptchaFactory captchaFactory;

    public Captcha generateCaptcha(Session session) {
        Captcha captcha = captchaFactory.generateRandomCaptcha(session);
        // 绑定关系
        if (!captchaRepository.bindCaptcha(captcha)) {
            throw new ServerBizException("获取图片验证码失败");
        }
        return captcha;
    }

    public boolean verifyCaptchaCode(Captcha captcha) {
        return captchaRepository.verifyCaptcha(captcha);
    }
}
