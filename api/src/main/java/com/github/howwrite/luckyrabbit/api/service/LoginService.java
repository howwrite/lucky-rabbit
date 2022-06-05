package com.github.howwrite.luckyrabbit.api.service;

import com.github.howwrite.treasure.api.response.Response;

/**
 * 登录相关服务
 *
 * @author howwrite
 * @date 2021/10/10 10:44 上午
 */
public interface LoginService {
    Response<Long> findUserIdByLoginToken(String loginToken);
}
