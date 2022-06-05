package com.github.howwrite.luckyrabbit.application.facade;

import com.github.howwrite.luckyrabbit.api.request.login.LoginBySmsCodeRequest;
import com.github.howwrite.luckyrabbit.api.response.login.UserLoginDTO;
import com.github.howwrite.luckyrabbit.domain.service.LoginDomainService;
import com.github.howwrite.luckyrabbit.domain.valueobject.LoginFactor;
import com.github.howwrite.luckyrabbit.domain.valueobject.Phone;
import com.github.howwrite.luckyrabbit.domain.valueobject.Session;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @author howwrite
 * @date 2021/10/10 10:49 上午
 */
@RequiredArgsConstructor
@Component
public class LoginFacade {
    private final LoginDomainService loginDomainService;

    public UserLoginDTO loginBySmsCode(LoginBySmsCodeRequest request) {
        Session session = new Session(request.getSessionId());
        Phone phone = new Phone(request.getPrefix(), request.getMobile());
        LoginFactor loginFactor = loginDomainService.loginBySmsCode(session, phone, request.getSmsCode());
        return new UserLoginDTO(loginFactor.getLoginToken(), loginFactor.getHourToLive());
    }

    public Long findUserIdByLoginToken(String loginToken) {
        return loginDomainService.findUserByToken(loginToken);
    }
}
