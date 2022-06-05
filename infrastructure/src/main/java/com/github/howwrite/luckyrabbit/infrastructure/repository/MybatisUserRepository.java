package com.github.howwrite.luckyrabbit.infrastructure.repository;

import com.github.howwrite.luckyrabbit.domain.model.User;
import com.github.howwrite.luckyrabbit.domain.queryobject.UserQuery;
import com.github.howwrite.luckyrabbit.domain.repository.UserRepository;
import com.github.howwrite.luckyrabbit.domain.valueobject.Phone;
import com.github.howwrite.luckyrabbit.infrastructure.dataobject.UserDO;
import com.github.howwrite.luckyrabbit.infrastructure.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.annotation.Nonnull;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class MybatisUserRepository implements UserRepository {
    private final UserMapper userMapper;

    @Override
    public Long insert(@Nonnull User user) {
        UserDO userDO = UserDO.buildByDomain(user);
        userMapper.insert(userDO);
        return userDO.getId();
    }

    @Override
    public User findByMobile(Phone phone) {
        UserQuery userQuery = new UserQuery();
        userQuery.setPrefix(phone.getPrefix());
        userQuery.setMobile(phone.getMobile());
        UserDO userDO = userMapper.get(userQuery);
        return Optional.ofNullable(userDO).map(UserDO::build2Domain).orElse(null);
    }
}
