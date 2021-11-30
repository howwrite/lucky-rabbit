package com.github.howwrite.luckyrabbit.application.converter;

import com.github.howwrite.luckyrabbit.application.dto.UserDTO;
import com.github.howwrite.luckyrabbit.domain.dataobject.UserDO;

/**
 * @author howwrite
 * @date 2021/11/25
 */
public class UserConverter {
    public static UserDO convertCreateParam(UserDTO userDTO) {
        UserDO userDO = new UserDO();
        userDO.setMobile(userDTO.getMobile());
        userDO.setPassword(userDTO.getPassword());
        userDO.setPrefix(userDTO.getPrefix());
        userDO.setNickname(userDTO.getNickname());
        return userDO;
    }

    public static UserDTO convert(UserDO data) {
        if (data == null) {
            return null;
        }
        UserDTO userDTO = new UserDTO();
        userDTO.setId(data.getId());
        userDTO.setNickname(data.getNickname());
        userDTO.setMobile(data.getMobile());
        userDTO.setPrefix(data.getPrefix());
        userDTO.setPassword(data.getPassword());
        return userDTO;
    }
}
