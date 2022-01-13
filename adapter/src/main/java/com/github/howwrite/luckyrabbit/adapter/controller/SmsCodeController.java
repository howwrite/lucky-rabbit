package com.github.howwrite.luckyrabbit.adapter.controller;

import com.github.howwrite.luckyrabbit.api.constant.SmsCodeSceneEnum;
import com.github.howwrite.luckyrabbit.api.facade.SmsCodeFacade;
import com.github.howwrite.luckyrabbit.api.request.login.SendSmsCodeRequest;
import com.github.howwrite.treasure.web.exception.WebRestException;
import com.github.howwrite.treasure.web.util.WebResultUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author howwrite
 * @date 2021/11/23
 */
@RequiredArgsConstructor
@RequestMapping("/api/sms")
@RestController
@Slf4j
public class SmsCodeController {
    private final SmsCodeFacade smsCodeFacade;

    @GetMapping("/send")
    public Boolean sendSmsCode(HttpServletRequest request,
                               @RequestParam String prefix,
                               @RequestParam String mobile,
                               @RequestParam String sendScene,
                               @RequestParam String captcha,
                               @RequestParam String captchaToken) {
        SmsCodeSceneEnum sceneEnum = SmsCodeSceneEnum.generate(sendScene);
        if (sceneEnum == null) {
            log.error("非法短信场景, scene:{}", sendScene);
            throw new WebRestException("非法请求");
        }
        SendSmsCodeRequest sendSmsCodeRequest = new SendSmsCodeRequest();
        sendSmsCodeRequest.setSessionId(request.getSession().getId());
        sendSmsCodeRequest.setPrefix(prefix);
        sendSmsCodeRequest.setMobile(mobile);
        sendSmsCodeRequest.setScene(sceneEnum);
        sendSmsCodeRequest.setCaptcha(captcha);
        sendSmsCodeRequest.setCaptchaToken(captchaToken);
        return WebResultUtil.resultOrThrow(smsCodeFacade.sendSmsCode(sendSmsCodeRequest));
    }

}
