package com.github.howwrite.luckyrabbit.loginsdk.filter;

import com.github.howwrite.luckyrabbit.api.facade.LoginFacade;
import com.github.howwrite.luckyrabbit.api.request.login.FindUserByLoginTokenRequest;
import com.github.howwrite.luckyrabbit.loginsdk.helper.LoginSessionDecodeHelper;
import com.github.howwrite.luckyrabbit.loginsdk.sdk.UserContext;
import com.github.howwrite.treasure.api.response.Response;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author howwrite
 * @date 2021/11/30
 */
@Slf4j
@RequiredArgsConstructor
public class UserFilter implements Filter {
    private final LoginFacade loginFacade;
    private final LoginSessionDecodeHelper loginSessionDecodeHelper;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        if (!(request instanceof HttpServletRequest)) {
            chain.doFilter(request, response);
            return;
        }
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        String loginToken = loginSessionDecodeHelper.genLoginToken(httpServletRequest);
        if (StringUtils.hasText(loginToken)) {
            FindUserByLoginTokenRequest loginRequest = new FindUserByLoginTokenRequest(loginToken);
            Response<Long> findUserTokenResp = loginFacade.findUserIdByLoginToken(loginRequest);
            if (!findUserTokenResp.isSuccess()) {
                log.warn("invoke login service error, param:{}, resp:{}", loginRequest, findUserTokenResp);
            } else {
                UserContext.setCurrentUserId(findUserTokenResp.getData());
            }
        }

        chain.doFilter(request, response);
    }
}
