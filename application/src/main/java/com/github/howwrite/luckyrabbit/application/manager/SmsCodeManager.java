package com.github.howwrite.luckyrabbit.application.manager;

import cn.hutool.core.util.RandomUtil;
import com.github.howwrite.luckyrabbit.api.request.login.SendSmsCodeRequest;
import com.github.howwrite.luckyrabbit.application.config.AppProperties;
import com.github.howwrite.luckyrabbit.domain.nosql.SmsCodeRdb;
import com.github.howwrite.treasure.common.exception.ServerBizException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author howwrite
 * @date 2021/11/23
 */
@RequiredArgsConstructor
@Component
@Slf4j
public class SmsCodeManager {
    private final SmsCodeRdb smsCodeRdb;
    private final AppProperties appProperties;

    public Boolean sendSmsCode(SendSmsCodeRequest request) {
        // 生成验证码
        String smsCode = genSmsCode(request.getSessionId(), request.getPrefix(), request.getMobile(), request.getScene().name());
        log.info("generate sms code success, smsCode:{}", smsCode);
        // todo 发送验证码
        return true;
    }

    public boolean verifySmsCode(String sessionId, String prefix, String mobile, String smsCodeScene, String smsCode) {
        return smsCodeRdb.verifySmsCode(sessionId, prefix, mobile, smsCodeScene, smsCode);
    }

    private String genSmsCode(String sessionId, String prefix, String mobile, String smsCodeScene) {
        int smsCodeLiveMinute = appProperties.getSmsCodeLiveMinute();
        // 首先查询是否当前用户是否已经存在短信验证码
        String existSmCode = smsCodeRdb.findSmsCode(sessionId, prefix, mobile, smsCodeScene, smsCodeLiveMinute);
        if (existSmCode != null) {
            // 存在则直接返回
            return existSmCode;
        }
        // 不存在则生成后绑定
        String smsCode = RandomUtil.randomNumbers(appProperties.getSmsCodeLength());
        boolean bindResult = smsCodeRdb.bindSmsCode(sessionId, prefix, mobile, smsCodeScene, smsCode, smsCodeLiveMinute);
        if (!bindResult) {
            log.error("bind sms code error, sessionId:{} prefix:{}, mobile:{}, smsCodeScene:{}, smsCode:{}", sessionId, prefix, mobile, smsCodeScene, smsCode);
            throw new ServerBizException("生成短信验证码失败，请稍后再试");
        }
        return smsCode;
    }
}
