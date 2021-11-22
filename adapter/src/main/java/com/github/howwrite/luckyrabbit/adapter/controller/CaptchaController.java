package com.github.howwrite.luckyrabbit.adapter.controller;

import com.github.howwrite.luckyrabbit.adapter.util.CaptchaUtils;
import com.github.howwrite.luckyrabbit.api.facade.CaptchaFacade;
import com.github.howwrite.luckyrabbit.api.request.GenerateCaptchaRequest;
import com.github.howwrite.luckyrabbit.api.request.VerifyCaptchaCodeRequest;
import com.github.howwrite.luckyrabbit.api.response.CaptchaInfo;
import com.github.howwrite.luckyrabbit.api.response.GenerateCaptchaInfo;
import com.github.howwrite.treasure.api.response.Response;
import com.github.howwrite.treasure.web.util.WebResultUtil;
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
    public CaptchaInfo generateCaptcha(HttpServletRequest request, @RequestParam Integer width, @RequestParam Integer height) {
        GenerateCaptchaRequest generateCaptchaRequest = new GenerateCaptchaRequest();
        generateCaptchaRequest.setWidth(width);
        generateCaptchaRequest.setHeight(height);

        String sessionId = request.getSession().getId();
        generateCaptchaRequest.setSessionId(sessionId);
        Response<GenerateCaptchaInfo> captchaResponse = captchaFacade.generateCaptcha(generateCaptchaRequest);
        GenerateCaptchaInfo captchaInfo = WebResultUtil.resultOrThrow(captchaResponse);
        String imageBody = BASE64_PREFIX + CaptchaUtils.generateCaptchaBase64Str(generateCaptchaRequest.getWidth(), generateCaptchaRequest.getHeight(), captchaInfo.getCaptchaBody());
        return new CaptchaInfo(imageBody, captchaInfo.getCaptchaToken());
    }

    @GetMapping("/verify")
    public Boolean verifyCaptcha(HttpServletRequest request, @RequestParam String captchaToken, @RequestParam String captcha) {
        return WebResultUtil.resultOrThrow(
                captchaFacade.verifyCaptchaCode(new VerifyCaptchaCodeRequest(captcha, request.getSession().getId(), captchaToken))
        );
    }
}
