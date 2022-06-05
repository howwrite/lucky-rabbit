package com.github.howwrite.luckyrabbit.domain.service;

import cn.hutool.core.util.RandomUtil;
import com.github.howwrite.luckyrabbit.common.constant.SmsCodeSceneEnum;
import com.github.howwrite.luckyrabbit.domain.config.AppProperties;
import com.github.howwrite.luckyrabbit.domain.model.User;
import com.github.howwrite.luckyrabbit.domain.repository.LoginRepository;
import com.github.howwrite.luckyrabbit.domain.valueobject.LoginFactor;
import com.github.howwrite.luckyrabbit.domain.valueobject.Phone;
import com.github.howwrite.luckyrabbit.domain.valueobject.Session;
import com.github.howwrite.treasure.common.exception.ServerBizException;
import com.github.howwrite.treasure.common.exception.ServerException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Nonnull;
import javax.annotation.Resource;

@Slf4j
@Service
@RequiredArgsConstructor
public class LoginDomainService {
    private final AppProperties appProperties;
    private final LoginRepository loginRepository;
    @Resource
    private SmsCodeDomainService smsCodeDomainService;

    @Resource
    private UserDomainService userDomainService;

    public LoginFactor loginBySmsCode(@Nonnull Session session, @Nonnull Phone phone, String smsCode) {
        boolean verifyResult = smsCodeDomainService.verifySmsCode(session, phone, SmsCodeSceneEnum.LOGIN, smsCode);
        if (!verifyResult) {
            throw new ServerBizException("短信验证码错误");
        }
        // 用户存在直接登录，不存在注册后登录
        User userByMobile = userDomainService.findUserByPhone(phone);
        if (userByMobile != null) {
            return bindLoginStatus(userByMobile.getId());
        }
        Long userId = userDomainService.createUserByPhone(phone);
        return bindLoginStatus(userId);
    }

    /**
     * 生成登录绑定token
     */
    public LoginFactor bindLoginStatus(Long userId) {
        String token = genLoginToken(userId);
        int loginStatusLiveToHour = appProperties.getLoginStatusLiveToHour();
        boolean bindResult = loginRepository.bindLoginToken(token, userId, loginStatusLiveToHour);
        if (!bindResult) {
            log.error("bind login token error, token:{}, userId:{}", token, userId);
            throw new ServerException();
        }
        return new LoginFactor(token, loginStatusLiveToHour);
    }

    public Long findUserByToken(String loginToken) {
        return loginRepository.findUserIdByToken(loginToken);
    }

    public String genLoginToken(Long userId) {
        return RandomUtil.randomString(32);
    }
}
