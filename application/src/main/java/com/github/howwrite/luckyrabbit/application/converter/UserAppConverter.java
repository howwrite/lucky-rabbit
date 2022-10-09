package com.github.howwrite.luckyrabbit.application.converter;

import com.github.howwrite.luckyrabbit.api.response.user.UserDTO;
import com.github.howwrite.luckyrabbit.domain.miap.user.model.User;

public class UserAppConverter {

    public static UserDTO domain2DTO(User user) {
        if (user == null) {
            return null;
        }
        UserDTO userDTO = new UserDTO(user.getNickname(), user.getPhone().getPrefix(), user.getPhone().getMobile());
        userDTO.setAvatarUrl(user.getAvatarUrl());
        return userDTO;
    }
}
