package com.github.howwrite.luckyrabbit.domain.service;

import com.github.howwrite.luckyrabbit.domain.endpoint.UserEndpoint;
import com.github.howwrite.luckyrabbit.domain.miap.user.model.User;
import com.github.howwrite.luckyrabbit.domain.miap.user.model.UserQuery;
import com.github.howwrite.luckyrabbit.domain.miap.user.repository.UserRepository;
import com.github.howwrite.luckyrabbit.domain.valueobject.Phone;
import com.github.howwrite.treasure.common.exception.ServerBizException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Nonnull;

@Service
public class UserDomainService {

    private final UserEndpoint userEndpoint;
    private final UserRepository userRepository;

    public UserDomainService(@Autowired(required = false) UserEndpoint userEndpoint, UserRepository userRepository) {
        this.userEndpoint = userEndpoint;
        this.userRepository = userRepository;
    }

    public User findUserByPhone(@Nonnull Phone phone) {
        return userRepository.findUser(new UserQuery(phone));
    }


    public Long createUserByPhone(@Nonnull Phone phone) {
        User userByMobile = userRepository.findUser(new UserQuery(phone));
        if (userByMobile != null) {
            throw new ServerBizException("该手机号已注册，请登录~");
        }
        User createParam = generateUserByPhone(phone);
        return userRepository.insert(createParam);
    }

    private User generateUserByPhone(Phone phone) {
        User user = new User(phone);
        user.setNickname(genNicknameByMobile(phone));
        return user;
    }

    /**
     * 根据手机号生成默认昵称
     */
    private String genNicknameByMobile(Phone phone) {
        if (userEndpoint != null) {
            return userEndpoint.genNicknameByMobile(phone);
        }
        return phone.getMobile();
    }
}
