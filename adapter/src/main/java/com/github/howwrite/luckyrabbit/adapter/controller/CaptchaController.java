package com.github.howwrite.luckyrabbit.adapter.controller;

import com.github.howwrite.luckyrabbit.adapter.util.CaptchaUtils;
import com.github.howwrite.luckyrabbit.api.request.captcha.GenerateCaptchaRequest;
import com.github.howwrite.luckyrabbit.api.response.captcha.CaptchaDTO;
import com.github.howwrite.luckyrabbit.api.response.captcha.GenerateCaptchaDTO;
import com.github.howwrite.luckyrabbit.application.facade.CaptchaFacade;
import com.github.howwrite.treasure.api.response.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author howwrite
 * @date 2021/10/11 10:17 下午
 */
@RequestMapping("/api/captcha")
@RestController
@RequiredArgsConstructor
public class CaptchaController {
    public static final String BASE64_PREFIX = "data:image/png;base64,";
    private final CaptchaFacade captchaFacade;

    @GetMapping("/generate")
    public Response<CaptchaDTO> generateCaptcha(HttpServletRequest request, @RequestParam Integer width, @RequestParam Integer height) {
        GenerateCaptchaRequest generateCaptchaRequest = new GenerateCaptchaRequest();
        generateCaptchaRequest.setWidth(width);
        generateCaptchaRequest.setHeight(height);

        String sessionId = request.getSession().getId();
        generateCaptchaRequest.setSessionId(sessionId);
        GenerateCaptchaDTO captchaResponse = captchaFacade.generateCaptcha(generateCaptchaRequest);
        String imageBody = BASE64_PREFIX + CaptchaUtils.generateCaptchaBase64Str(generateCaptchaRequest.getWidth(), generateCaptchaRequest.getHeight(), captchaResponse.getCaptchaBody());
        return Response.ok(new CaptchaDTO(imageBody, captchaResponse.getCaptchaToken()));
    }
}
