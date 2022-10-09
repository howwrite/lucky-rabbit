package com.github.howwrite.luckyrabbit.domain.miap.user.context;

import com.github.howwrite.luckyrabbit.domain.miap.user.model.User;
import com.github.howwrite.miap.def.MiapPreface;

/**
 * 用户上下文，可以set和get用户信息
 */
public interface UserContext extends MiapPreface {

    User getUser();

    void setUser(User user);
}
