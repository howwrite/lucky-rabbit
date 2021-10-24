package com.github.howwrite.luckyrabbit.application.facade;

import com.github.howwrite.luckyrabbit.api.facade.UserFacade;
import com.github.howwrite.luckyrabbit.api.request.RegisterUserRequest;
import com.github.howwrite.luckyrabbit.api.response.LoginInfo;
import com.github.howwrite.luckyrabbit.application.manage.UserManage;
import com.github.howwrite.treasure.api.response.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @author howwrite
 * @date 2021/10/10 10:49 上午
 */
@RequiredArgsConstructor
@Component
public class UserFacadeImpl implements UserFacade {
    private UserManage userManage;

    @Override
    public Response<LoginInfo> register(RegisterUserRequest request) {
        return Response.ok(userManage.register(request));
    }

    @Override
    public void sendSmsVerificationCodeByRegister() {

    }
}
