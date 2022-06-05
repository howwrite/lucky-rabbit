package com.github.howwrite.luckyrabbit.application.facade;

import com.github.howwrite.luckyrabbit.common.constant.SmsCodeSceneEnum;
import com.github.howwrite.luckyrabbit.domain.model.Captcha;
import com.github.howwrite.luckyrabbit.domain.service.SmsCodeDomainService;
import com.github.howwrite.luckyrabbit.domain.valueobject.Phone;
import com.github.howwrite.luckyrabbit.domain.valueobject.Session;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @author howwrite
 * @date 2021/11/23
 */
@RequiredArgsConstructor
@Component
public class SmsCodeFacade {
    private final SmsCodeDomainService smsCodeDomainService;

    public boolean sendSmsCode(String prefix, String mobile, SmsCodeSceneEnum sceneEnum, String captcha, String captchaToken, String sessionId) {
        return smsCodeDomainService.sendSmsCode(new Captcha(captchaToken, captcha, new Session(sessionId)), new Phone(prefix, mobile), sceneEnum);
    }
}
