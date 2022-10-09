package com.github.howwrite.luckyrabbit.loginsdk.interceptor;

import com.github.howwrite.luckyrabbit.api.request.user.UserQueryParam;
import com.github.howwrite.luckyrabbit.api.response.user.UserDTO;
import com.github.howwrite.luckyrabbit.api.service.LoginService;
import com.github.howwrite.luckyrabbit.api.service.UserService;
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
    private final LoginService loginService;
    private final LoginSessionDecodeHelper loginSessionDecodeHelper;

    private final UserService userService;

    @Override
    public boolean preHandle(@Nonnull HttpServletRequest request, @Nonnull HttpServletResponse response, @Nonnull Object handler) {
        String loginToken = loginSessionDecodeHelper.genLoginToken(request);
        if (!StringUtils.hasText(loginToken)) {
            log.info("current request not have login token");
            genLoginIllegalResponse(response);
            return false;
        }
        Response<Long> findUserTokenResp = loginService.findUserIdByLoginToken(loginToken);
        Long userId = findUserTokenResp.getData();
        if (!findUserTokenResp.isOk() || userId == null) {
            log.warn("根据token查询用户id失败, param:{}, resp:{}", loginToken, findUserTokenResp);
            genLoginIllegalResponse(response);
            return false;
        }
        Response<UserDTO> userResp = userService.findLegalUser(new UserQueryParam(userId));
        UserDTO userDTO = userResp.getData();
        if (!userResp.isOk() || userDTO == null) {
            log.warn("用户id不合法, 用户id:{}, resp:{}", userId, userResp);
            genLoginIllegalResponse(response);
            return false;
        }
        UserContext.setCurrentUserId(userDTO);
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
