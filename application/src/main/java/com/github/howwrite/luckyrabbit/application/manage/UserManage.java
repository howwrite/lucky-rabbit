package com.github.howwrite.luckyrabbit.application.manage;

import com.github.howwrite.luckyrabbit.api.request.RegisterUserRequest;
import com.github.howwrite.luckyrabbit.api.response.LoginInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author howwrite
 * @date 2021/10/10 11:23 上午
 */
@RequiredArgsConstructor
@Component
public class UserManage {
    @Resource
    private LoginManage loginManage;

    public LoginInfo register(RegisterUserRequest request) {
        // todo
        // 校验验证码是否正确
        // 校验手机号是否重复
        // 校验昵称是否重复
        // 校验密码强度
        return null;
    }
}
