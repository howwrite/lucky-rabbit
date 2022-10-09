package com.github.howwrite.luckyrabbit.adapter.controller;

import com.github.howwrite.luckyrabbit.api.request.login.LoginBySmsCodeRequest;
import com.github.howwrite.luckyrabbit.api.response.login.UserLoginDTO;
import com.github.howwrite.luckyrabbit.api.response.user.UserDTO;
import com.github.howwrite.luckyrabbit.application.facade.LoginFacade;
import com.github.howwrite.luckyrabbit.application.facade.UserFacade;
import com.github.howwrite.luckyrabbit.loginsdk.config.LoginSdkProperties;
import com.github.howwrite.luckyrabbit.loginsdk.sdk.UserContext;
import com.github.howwrite.treasure.adapter.util.RequestUtils;
import com.github.howwrite.treasure.api.response.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author howwrite
 * @date 2021/11/24
 */
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/login")
public class LoginController {
    private final LoginFacade loginFacade;
    private final LoginSdkProperties loginSdkProperties;
    private final UserFacade userFacade;

    @PostMapping("/by-sms-code")
    public Response<Boolean> loginBySmsCode(HttpServletRequest httpRequest, HttpServletResponse response, @RequestBody LoginBySmsCodeRequest request) {
        String sessionId = httpRequest.getSession().getId();
        request.setSessionId(sessionId);
        UserLoginDTO loginResult = loginFacade.loginBySmsCode(request);
        RequestUtils.writeCookie(response, loginSdkProperties.getLoginCookieName(), loginResult.getLoginToken(), loginResult.getHourToLive() * 60 * 60);
        return Response.ok(true);
    }

    @GetMapping("/current")
    public Response<Boolean> current() {
        return Response.ok(UserContext.currentUser() != null);
    }

    @GetMapping("/current-user-info")
    public Response<UserDTO> userInfo() {
        return Response.ok(UserContext.currentUser());
    }
}
