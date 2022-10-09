package com.github.howwrite.luckyrabbit.api.service;

import com.github.howwrite.luckyrabbit.api.request.user.UserQueryParam;
import com.github.howwrite.luckyrabbit.api.response.user.UserDTO;
import com.github.howwrite.treasure.api.response.Response;

public interface UserService {
    /**
     * 查询合法的用户
     *
     * @param userQueryParam 查询条件
     * @return 存在且合法的用户或者null
     */
    Response<UserDTO> findLegalUser(UserQueryParam userQueryParam);
}
