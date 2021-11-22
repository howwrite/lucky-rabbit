package com.github.howwrite.luckyrabbit.application.manager;

import cn.hutool.core.util.RandomUtil;
import com.github.howwrite.luckyrabbit.api.request.GenerateCaptchaRequest;
import com.github.howwrite.luckyrabbit.api.request.VerifyCaptchaCodeRequest;
import com.github.howwrite.luckyrabbit.api.response.GenerateCaptchaInfo;
import com.github.howwrite.luckyrabbit.application.config.AppProperties;
import com.github.howwrite.luckyrabbit.domain.nosql.CaptchaRdb;
import com.github.howwrite.treasure.common.exception.ServerBizException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @author howwrite
 * @date 2021/10/12 8:55 上午
 */
@Component
@RequiredArgsConstructor
public class CaptchaManager {
    private final CaptchaRdb captchaRdb;
    private final AppProperties appProperties;

    public GenerateCaptchaInfo generateCaptcha(GenerateCaptchaRequest request) {
        // 生成captchaBody
        String captchaBody = RandomUtil.randomString(appProperties.getCaptchaBodyLength());
        // 生成token
        String captchaToken = RandomUtil.randomString(32);
        // 绑定关系
        String sessionId = request.getSessionId();
        if (!captchaRdb.bindCaptcha(sessionId, captchaToken, captchaBody, appProperties.getCaptchaLiveMinute())) {
            throw new ServerBizException("获取图片验证码失败");
        }
        return new GenerateCaptchaInfo(captchaToken, captchaBody);
    }

    public boolean verifyCaptchaCode(VerifyCaptchaCodeRequest request) {
        return captchaRdb.verifyCaptcha(request.getSessionId(), request.getCaptchaToken(), request.getCaptchaCode());
    }
}
