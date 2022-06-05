package com.github.howwrite.luckyrabbit.adapter.provider;

import com.github.howwrite.luckyrabbit.api.service.LoginService;
import com.github.howwrite.luckyrabbit.application.facade.LoginFacade;
import com.github.howwrite.treasure.api.response.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginServiceImpl implements LoginService {
    private final LoginFacade loginFacade;

    @Override
    public Response<Long> findUserIdByLoginToken(String loginToken) {
        return Response.ok(loginFacade.findUserIdByLoginToken(loginToken));
    }
}
