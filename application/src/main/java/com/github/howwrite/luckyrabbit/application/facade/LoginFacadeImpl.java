package com.github.howwrite.luckyrabbit.application.facade;

import com.github.howwrite.luckyrabbit.api.facade.LoginFacade;
import com.github.howwrite.luckyrabbit.api.request.login.FindUserByLoginTokenRequest;
import com.github.howwrite.luckyrabbit.api.request.login.LoginBySmsCodeRequest;
import com.github.howwrite.luckyrabbit.api.response.login.UserLoginInfo;
import com.github.howwrite.luckyrabbit.application.manager.LoginManager;
import com.github.howwrite.treasure.api.response.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @author howwrite
 * @date 2021/10/10 10:49 上午
 */
@RequiredArgsConstructor
@Component
public class LoginFacadeImpl implements LoginFacade {
    private final LoginManager loginManager;

    @Override
    public Response<UserLoginInfo> loginBySmsCode(LoginBySmsCodeRequest request) {
        return Response.ok(loginManager.loginBySmsCode(request));
    }

    @Override
    public Response<Long> findUserIdByLoginToken(FindUserByLoginTokenRequest request) {
        return Response.ok(loginManager.findUserByToken(request));
    }
}
