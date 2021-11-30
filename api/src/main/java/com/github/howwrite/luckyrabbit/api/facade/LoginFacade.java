package com.github.howwrite.luckyrabbit.api.facade;

import com.github.howwrite.luckyrabbit.api.request.login.FindUserByLoginTokenRequest;
import com.github.howwrite.luckyrabbit.api.request.login.LoginBySmsCodeRequest;
import com.github.howwrite.luckyrabbit.api.response.login.UserLoginInfo;
import com.github.howwrite.treasure.api.response.Response;

/**
 * 登录相关服务
 *
 * @author howwrite
 * @date 2021/10/10 10:44 上午
 */
public interface LoginFacade {

    Response<UserLoginInfo> loginBySmsCode(LoginBySmsCodeRequest request);

    Response<Long> findUserIdByLoginToken(FindUserByLoginTokenRequest request);
}
