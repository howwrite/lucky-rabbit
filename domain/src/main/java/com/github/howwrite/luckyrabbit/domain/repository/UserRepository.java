package com.github.howwrite.luckyrabbit.domain.repository;

import com.github.howwrite.luckyrabbit.domain.model.User;
import com.github.howwrite.luckyrabbit.domain.valueobject.Phone;

public interface UserRepository {

    Long insert(User user);

    User findByMobile(Phone phone);
}
