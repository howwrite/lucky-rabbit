package com.github.howwrite.luckyrabbit.domain.repository;

import com.github.howwrite.luckyrabbit.domain.model.Captcha;

public interface CaptchaRepository {
    boolean bindCaptcha(Captcha captcha);

    boolean verifyCaptcha(Captcha captcha);
}
