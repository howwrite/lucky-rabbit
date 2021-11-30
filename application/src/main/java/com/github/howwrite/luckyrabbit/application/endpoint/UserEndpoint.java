package com.github.howwrite.luckyrabbit.application.endpoint;

import javax.validation.constraints.NotNull;

/**
 * @author howwrite
 * @date 2021/11/25
 */
public interface UserEndpoint {
    String genNicknameByMobile(@NotNull String mobile);
}
