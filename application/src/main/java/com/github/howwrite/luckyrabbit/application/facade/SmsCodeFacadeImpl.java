package com.github.howwrite.luckyrabbit.application.facade;

import com.github.howwrite.luckyrabbit.api.facade.SmsCodeFacade;
import com.github.howwrite.luckyrabbit.api.request.login.SendSmsCodeRequest;
import com.github.howwrite.luckyrabbit.application.manager.SmsCodeManager;
import com.github.howwrite.treasure.api.response.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @author howwrite
 * @date 2021/11/23
 */
@RequiredArgsConstructor
@Component
public class SmsCodeFacadeImpl implements SmsCodeFacade {
    private final SmsCodeManager smsCodeManager;

    @Override
    public Response<Boolean> sendSmsCode(SendSmsCodeRequest request) {
        return Response.ok(smsCodeManager.sendSmsCode(request));
    }
}
