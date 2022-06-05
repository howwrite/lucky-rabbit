package com.github.howwrite.luckyrabbit.adapter.controller;

import com.github.howwrite.luckyrabbit.application.facade.SmsCodeFacade;
import com.github.howwrite.luckyrabbit.common.constant.SmsCodeSceneEnum;
import com.github.howwrite.treasure.api.response.Response;
import com.github.howwrite.treasure.common.exception.ServerBizException;
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
    public Response<Boolean> sendSmsCode(HttpServletRequest request,
                                         @RequestParam String prefix,
                                         @RequestParam String mobile,
                                         @RequestParam String sendScene,
                                         @RequestParam String captcha,
                                         @RequestParam String captchaToken) {
        SmsCodeSceneEnum sceneEnum = SmsCodeSceneEnum.generate(sendScene);
        if (sceneEnum == null) {
            log.error("非法短信场景, scene:{}", sendScene);
            throw new ServerBizException("系统错误，请刷新页面后重试");
        }
        String sessionId = request.getSession().getId();
        return Response.ok(smsCodeFacade.sendSmsCode(prefix, mobile, sceneEnum, captcha, captchaToken, sessionId));
    }

}
