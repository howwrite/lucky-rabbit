package com.github.howwrite.luckyrabbit.loginsdk.helper;

import com.github.howwrite.luckyrabbit.loginsdk.config.LoginSdkProperties;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * @author howwrite
 * @date 2021/11/27
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class LoginSessionDecodeHelper {
    private final LoginSdkProperties loginSdkProperties;

    public String genLoginToken(HttpServletRequest httpRequest) {
        Cookie[] cookies = httpRequest.getCookies();
        if (cookies == null || cookies.length == 0) {
            return null;
        }
        for (Cookie cookie : cookies) {
            if (loginSdkProperties.getLoginCookieName().equals(cookie.getName())) {
                return cookie.getValue();
            }
        }
        return null;
    }
}
