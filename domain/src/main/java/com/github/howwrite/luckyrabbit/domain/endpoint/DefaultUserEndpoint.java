package com.github.howwrite.luckyrabbit.domain.endpoint;

import com.github.howwrite.luckyrabbit.domain.valueobject.Phone;

import javax.annotation.Nonnull;

public class DefaultUserEndpoint implements UserEndpoint {
    @Override
    public String genNicknameByMobile(@Nonnull Phone phone) {
        // todo nick要唯一
        return phone.getMobile();
    }
}
