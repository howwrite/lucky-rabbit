package com.github.howwrite.luckyrabbit.domain.service;

import cn.hutool.core.util.RandomUtil;
import com.github.howwrite.luckyrabbit.common.constant.SmsCodeSceneEnum;
import com.github.howwrite.luckyrabbit.domain.model.Captcha;
import com.github.howwrite.luckyrabbit.domain.repository.SmsCodeRepository;
import com.github.howwrite.luckyrabbit.domain.valueobject.Phone;
import com.github.howwrite.luckyrabbit.domain.valueobject.Session;
import com.github.howwrite.luckyrabbit.tools.config.LuckyRabbitConfig;
import com.github.howwrite.treasure.common.exception.ServerBizException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Nonnull;

@Slf4j
@Service
@RequiredArgsConstructor
public class SmsCodeDomainService {

    private final CaptchaDomainService captchaDomainService;

    private final SmsCodeRepository smsCodeRepository;

    private final LuckyRabbitConfig luckyrabbitConfig;

    public boolean sendSmsCode(@Nonnull Captcha captcha, @Nonnull Phone phone, @Nonnull SmsCodeSceneEnum scene) {
        // 校验图形验证码
        boolean verifyResult = captchaDomainService.verifyCaptchaCode(captcha);
        if (!verifyResult) {
            throw new ServerBizException("验证码错误，请重新输入或者更新验证码");
        }
        // 生成验证码
        String smsCode = genSmsCode(captcha.getSession(), phone, scene);
        log.info("generate sms code success, smsCode:{}", smsCode);
        // todo 发送验证码
        return true;
    }

    private String genSmsCode(Session session, Phone phone, SmsCodeSceneEnum scene) {
        int smsCodeLiveMinute = luckyrabbitConfig.getSmsCodeLiveMinute();
        // 首先查询是否当前用户是否已经存在短信验证码
        String existSmCode = smsCodeRepository.findSmsCode(session, phone, scene, smsCodeLiveMinute);
        if (existSmCode != null) {
            // 存在则直接返回
            return existSmCode;
        }
        // 不存在则生成后绑定
        String smsCode = RandomUtil.randomNumbers(luckyrabbitConfig.getSmsCodeLength());
        boolean bindResult = smsCodeRepository.bindSmsCode(session, phone, scene, smsCode, smsCodeLiveMinute);
        if (!bindResult) {
            log.error("bind sms code error, sessionId:{}, mobile:{}, smsCodeScene:{}, smsCode:{}", session, phone, scene, smsCode);
            throw new ServerBizException("生成短信验证码失败，请稍后再试");
        }
        return smsCode;
    }

    public boolean verifySmsCode(Session session, Phone phone, SmsCodeSceneEnum sceneEnum, String smsCode) {
        return smsCodeRepository.verifySmsCode(session, phone, sceneEnum, smsCode);
    }

}
