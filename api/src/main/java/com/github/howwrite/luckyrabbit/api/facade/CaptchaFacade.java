package com.github.howwrite.luckyrabbit.api.facade;

import com.github.howwrite.luckyrabbit.api.request.captcha.GenerateCaptchaRequest;
import com.github.howwrite.luckyrabbit.api.request.captcha.VerifyCaptchaCodeRequest;
import com.github.howwrite.luckyrabbit.api.response.captcha.GenerateCaptchaInfo;
import com.github.howwrite.treasure.api.response.Response;

/**
 * @author howwrite
 * @date 2021/10/12 8:42 上午
 */
public interface CaptchaFacade {
    Response<GenerateCaptchaInfo> generateCaptcha(GenerateCaptchaRequest request);

    Response<Boolean> verifyCaptchaCode(VerifyCaptchaCodeRequest request);
}
