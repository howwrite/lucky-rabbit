package com.github.howwrite.luckyrabbit.api.facade;

import com.github.howwrite.luckyrabbit.api.request.RegisterUserRequest;
import com.github.howwrite.luckyrabbit.api.response.LoginInfo;
import com.github.howwrite.treasure.api.response.Response;

/**
 * 用户服务
 *
 * @author howwrite
 * @date 2021/10/10 10:43 上午
 */
public interface UserFacade {
    /**
     * 注册用户接口
     *
     * @param request 用户信息
     * @return 用户登录状态
     */
    Response<LoginInfo> register(RegisterUserRequest request);

    void sendSmsVerificationCodeByRegister();
}
