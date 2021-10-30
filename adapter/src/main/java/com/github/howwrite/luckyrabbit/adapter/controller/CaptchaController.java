package com.github.howwrite.luckyrabbit.adapter.controller;

import com.github.howwrite.luckyrabbit.adapter.config.AdapterProperties;
import com.github.howwrite.luckyrabbit.adapter.util.CaptchaUtils;
import com.github.howwrite.luckyrabbit.api.facade.CaptchaFacade;
import com.github.howwrite.luckyrabbit.api.request.GenerateCaptchaRequest;
import com.github.howwrite.luckyrabbit.api.response.GenerateCaptchaInfo;
import com.github.howwrite.treasure.api.response.Response;
import com.github.howwrite.treasure.web.util.WebResultUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
    public static final String            BASE64_PREFIX = "data:image/png;base64,";
    private final       AdapterProperties adapterProperties;
    private final       CaptchaFacade     captchaFacade;

    @GetMapping("/generate")
    public String generateCaptcha(HttpServletRequest request) {
        String sessionId = request.getRequestedSessionId();
        Response<GenerateCaptchaInfo> captchaResponse = captchaFacade.generateCaptcha(new GenerateCaptchaRequest(sessionId));
        GenerateCaptchaInfo captchaInfo = WebResultUtil.resultOrThrow(captchaResponse);
        return BASE64_PREFIX + CaptchaUtils.generateCaptchaBase64Str(adapterProperties.getCaptchaWidth(), adapterProperties.getCaptchaHeight(), captchaInfo.getCaptchaBody());
    }
}
