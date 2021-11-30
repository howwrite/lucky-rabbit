package com.github.howwrite.luckyrabbit.application.manager;

import cn.hutool.core.util.RandomUtil;
import com.github.howwrite.luckyrabbit.api.constant.SmsCodeSceneEnum;
import com.github.howwrite.luckyrabbit.api.request.login.FindUserByLoginTokenRequest;
import com.github.howwrite.luckyrabbit.api.request.login.LoginBySmsCodeRequest;
import com.github.howwrite.luckyrabbit.api.response.login.UserLoginInfo;
import com.github.howwrite.luckyrabbit.application.config.AppProperties;
import com.github.howwrite.luckyrabbit.application.dto.UserDTO;
import com.github.howwrite.luckyrabbit.domain.nosql.LoginRdb;
import com.github.howwrite.treasure.common.exception.ServerBizException;
import com.github.howwrite.treasure.common.exception.ServerException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author howwrite
 * @date 2021/10/10 11:24 上午
 */
@Slf4j
@Component
public class LoginManager {
    @Resource
    private SmsCodeManager smsCodeManager;

    @Resource
    private UserManager userManager;

    @Resource
    private RegisterManager registerManager;

    @Resource
    private LoginRdb loginRdb;

    @Resource
    private AppProperties appProperties;

    public Long findUserByToken(FindUserByLoginTokenRequest request) {
        return loginRdb.findUserIdByToken(request.getLoginToken());
    }

    public UserLoginInfo loginBySmsCode(LoginBySmsCodeRequest request) {
        String mobile = request.getMobile();
        String prefix = request.getPrefix();
        boolean verifyResult = smsCodeManager.verifySmsCode(request.getSessionId(), prefix, mobile, SmsCodeSceneEnum.LOGIN.name(), request.getSmsCode());
        if (!verifyResult) {
            throw new ServerBizException("短信验证码错误");
        }
        // 用户存在直接登录，不存在注册后登录
        UserDTO userByMobile = userManager.findUserByMobile(prefix, mobile);
        if (userByMobile != null) {
            return bindLoginStatus(userByMobile.getId());
        }
        Long userId = registerManager.registerBySmsCode(prefix, mobile);
        return bindLoginStatus(userId);
    }

    /**
     * 生成登录绑定token
     */
    public UserLoginInfo bindLoginStatus(Long userId) {
        String token = genLoginToken(userId);
        int loginStatusLiveToHour = appProperties.getLoginStatusLiveToHour();
        boolean bindResult = loginRdb.bindLoginToken(token, userId, loginStatusLiveToHour);
        if (!bindResult) {
            log.error("bind login token error, token:{}, userId:{}", token, userId);
            throw new ServerException();
        }
        return new UserLoginInfo(token, loginStatusLiveToHour);
    }

    public String genLoginToken(Long userId) {
        return RandomUtil.randomString(32);
    }
}
