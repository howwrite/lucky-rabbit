package com.github.howwrite.luckyrabbit.application.facade;

import com.github.howwrite.luckyrabbit.api.facade.CaptchaFacade;
import com.github.howwrite.luckyrabbit.api.request.GenerateCaptchaRequest;
import com.github.howwrite.luckyrabbit.api.request.VerifyCaptchaCodeRequest;
import com.github.howwrite.luckyrabbit.api.response.GenerateCaptchaInfo;
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

    @Override
    public Response<Boolean> verifyCaptchaCode(VerifyCaptchaCodeRequest request) {
        return Response.ok(captchaManager.verifyCaptchaCode(request));
    }

}
