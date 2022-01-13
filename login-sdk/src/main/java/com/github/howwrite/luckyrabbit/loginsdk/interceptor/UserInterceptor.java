package com.github.howwrite.luckyrabbit.loginsdk.interceptor;

import com.github.howwrite.luckyrabbit.api.facade.LoginFacade;
import com.github.howwrite.luckyrabbit.api.request.login.FindUserByLoginTokenRequest;
import com.github.howwrite.luckyrabbit.loginsdk.helper.LoginSessionDecodeHelper;
import com.github.howwrite.luckyrabbit.loginsdk.sdk.UserContext;
import com.github.howwrite.treasure.api.response.Response;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.annotation.Nonnull;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author howwrite
 * @date 2021/11/30
 */
@Slf4j
@RequiredArgsConstructor
public class UserInterceptor implements HandlerInterceptor {
    private final LoginFacade loginFacade;
    private final LoginSessionDecodeHelper loginSessionDecodeHelper;

    @Override
    public boolean preHandle(@Nonnull HttpServletRequest request, @Nonnull HttpServletResponse response, @Nonnull Object handler) {
        String loginToken = loginSessionDecodeHelper.genLoginToken(request);
        if (!StringUtils.hasText(loginToken)) {
            log.warn("current request not have login token");
            genLoginIllegalResponse(response);
            return false;
        }
        FindUserByLoginTokenRequest loginRequest = new FindUserByLoginTokenRequest(loginToken);
        Response<Long> findUserTokenResp = loginFacade.findUserIdByLoginToken(loginRequest);
        if (!findUserTokenResp.isOk() || findUserTokenResp.getData() == null) {
            log.warn("invoke login service error, param:{}, resp:{}", loginRequest, findUserTokenResp);
            genLoginIllegalResponse(response);
            return false;
        }
        UserContext.setCurrentUserId(findUserTokenResp.getData());
        return true;
    }

    private void genLoginIllegalResponse(HttpServletResponse servletResponse) {
        servletResponse.setStatus(HttpStatus.UNAUTHORIZED.value());
    }

    @Override
    public void afterCompletion(@Nonnull HttpServletRequest request, @Nonnull HttpServletResponse response, @Nonnull Object handler, Exception ex) {
        UserContext.clear();
    }
}
