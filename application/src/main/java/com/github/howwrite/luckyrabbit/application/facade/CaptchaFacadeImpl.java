package com.github.howwrite.luckyrabbit.application.facade;

import com.github.howwrite.luckyrabbit.api.facade.CaptchaFacade;
import com.github.howwrite.luckyrabbit.api.request.captcha.GenerateCaptchaRequest;
import com.github.howwrite.luckyrabbit.api.response.captcha.GenerateCaptchaInfo;
import com.github.howwrite.luckyrabbit.application.manager.CaptchaManager;
import com.github.howwrite.treasure.api.response.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @author howwrite
 * @date 2021/10/12 8:55 上午
 */
@RequiredArgsConstructor
@Component
public class CaptchaFacadeImpl implements CaptchaFacade {
    private final CaptchaManager captchaManager;

    @Override
    public Response<GenerateCaptchaInfo> generateCaptcha(GenerateCaptchaRequest request) {
        return Response.ok(captchaManager.generateCaptcha(request));
    }
}
