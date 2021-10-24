package com.github.howwrite.luckyrabbit.api.facade;

/**
 * 登录相关服务
 *
 * @author howwrite
 * @date 2021/10/10 10:44 上午
 */
public interface LoginFacade {
    void login();

    void logout();

    void findLoginUser();
}
