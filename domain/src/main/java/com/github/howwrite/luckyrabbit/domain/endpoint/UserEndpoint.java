package com.github.howwrite.luckyrabbit.domain.endpoint;


import com.github.howwrite.luckyrabbit.domain.valueobject.Phone;

import javax.annotation.Nonnull;

/**
 * @author howwrite
 * @date 2021/11/25
 */
public interface UserEndpoint {
    String genNicknameByMobile(@Nonnull Phone phone);
}
