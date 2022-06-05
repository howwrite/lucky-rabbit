package com.github.howwrite.luckyrabbit.application.converter;

import com.github.howwrite.luckyrabbit.api.response.captcha.GenerateCaptchaDTO;
import com.github.howwrite.luckyrabbit.domain.model.Captcha;

public class CaptchaAppConverter {
    public static GenerateCaptchaDTO domain2DTO(Captcha captcha) {
        GenerateCaptchaDTO generateCaptchaDTO = new GenerateCaptchaDTO();
        generateCaptchaDTO.setCaptchaToken(captcha.getCaptchaToken());
        generateCaptchaDTO.setCaptchaBody(captcha.getCaptchaBody());
        return generateCaptchaDTO;
    }
}
