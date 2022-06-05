package com.github.howwrite.luckyrabbit.application.facade;

import com.github.howwrite.luckyrabbit.api.request.captcha.GenerateCaptchaRequest;
import com.github.howwrite.luckyrabbit.api.response.captcha.GenerateCaptchaDTO;
import com.github.howwrite.luckyrabbit.application.converter.CaptchaAppConverter;
import com.github.howwrite.luckyrabbit.domain.service.CaptchaDomainService;
import com.github.howwrite.luckyrabbit.domain.valueobject.Session;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @author howwrite
 * @date 2021/10/12 8:55 上午
 */
@RequiredArgsConstructor
@Component
public class CaptchaFacade {
    private final CaptchaDomainService captchaDomainService;

    public GenerateCaptchaDTO generateCaptcha(GenerateCaptchaRequest request) {
        return CaptchaAppConverter.domain2DTO(
                captchaDomainService.generateCaptcha(new Session(request.getSessionId()))
        );
    }
}
