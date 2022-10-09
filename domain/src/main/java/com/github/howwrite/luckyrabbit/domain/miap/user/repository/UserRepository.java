package com.github.howwrite.luckyrabbit.domain.miap.user.repository;

import com.github.howwrite.luckyrabbit.domain.miap.user.model.User;
import com.github.howwrite.luckyrabbit.domain.miap.user.model.UserQuery;

public interface UserRepository {

    Long insert(User user);

    User findUser(UserQuery userQuery);
}
