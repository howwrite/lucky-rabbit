package com.github.howwrite.luckyrabbit.api.facade;

import com.github.howwrite.luckyrabbit.api.request.login.SendSmsCodeRequest;
import com.github.howwrite.treasure.api.response.Response;

/**
 * @author howwrite
 * @date 2021/10/12 8:42 上午
 */
public interface SmsCodeFacade {
    Response<Boolean> sendSmsCode(SendSmsCodeRequest request);

}
