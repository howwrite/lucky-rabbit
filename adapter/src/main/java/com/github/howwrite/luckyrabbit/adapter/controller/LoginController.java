package com.github.howwrite.luckyrabbit.adapter.controller;

import com.github.howwrite.luckyrabbit.api.facade.LoginFacade;
import com.github.howwrite.luckyrabbit.api.request.login.LoginBySmsCodeRequest;
import com.github.howwrite.luckyrabbit.api.response.login.UserLoginInfo;
import com.github.howwrite.luckyrabbit.loginsdk.config.LoginSdkProperties;
import com.github.howwrite.luckyrabbit.loginsdk.sdk.UserContext;
import com.github.howwrite.treasure.api.response.Response;
import com.github.howwrite.treasure.web.util.WebResultUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
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

    @PostMapping("/by-sms-code")
    public Boolean loginBySmsCode(HttpServletRequest httpRequest, HttpServletResponse response, @RequestBody LoginBySmsCodeRequest request) {
        String sessionId = httpRequest.getSession().getId();
        request.setSessionId(sessionId);
        Response<UserLoginInfo> loginResponse = loginFacade.loginBySmsCode(request);
        UserLoginInfo loginResult = WebResultUtil.resultOrThrow(loginResponse);
        writeLoginCookie(response, loginResult.getLoginToken(), request.getAutoLogin(), loginResult.getHourToLive());
        return true;
    }

    @GetMapping("/current")
    public Boolean current() {
        return UserContext.currentUserId() != null;
    }

    private void writeLoginCookie(HttpServletResponse response, String token, Boolean autoLogin, Integer liveToHours) {
        Cookie cookie = new Cookie(loginSdkProperties.getLoginCookieName(), token);
        cookie.setHttpOnly(true);
        cookie.setPath("/");
        if (autoLogin == null || !autoLogin) {
            cookie.setMaxAge(-1);
        } else {
            cookie.setMaxAge(liveToHours * 60);
        }
        response.addCookie(cookie);
    }

}
