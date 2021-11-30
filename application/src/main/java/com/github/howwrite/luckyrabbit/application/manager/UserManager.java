package com.github.howwrite.luckyrabbit.application.manager;

import com.github.howwrite.luckyrabbit.application.converter.UserConverter;
import com.github.howwrite.luckyrabbit.application.dto.UserDTO;
import com.github.howwrite.luckyrabbit.domain.dataobject.UserDO;
import com.github.howwrite.luckyrabbit.domain.mapper.UserMapper;
import com.github.howwrite.treasure.common.exception.ServerBizException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;

/**
 * @author howwrite
 * @date 2021/10/10 11:23 上午
 */
@RequiredArgsConstructor
@Component
public class UserManager {
    @Resource
    private LoginManager loginManager;
    @Resource
    private UserMapper userMapper;

    public Long createUser(UserDTO userDTO) {
        if (StringUtils.hasLength(userDTO.getPrefix()) && StringUtils.hasLength(userDTO.getMobile())) {
            UserDTO userByMobile = findUserByMobile(userDTO.getPrefix(), userDTO.getMobile());
            if (userByMobile != null) {
                throw new ServerBizException("手机号已经注册啦~");
            }
        }
        UserDO createParam = UserConverter.convertCreateParam(userDTO);
        userMapper.insert(createParam);
        return createParam.getId();
    }

    public UserDTO findUserByMobile(String prefix, String mobile) {
        UserDO userDO = userMapper.findByMobile(prefix, mobile);
        return UserConverter.convert(userDO);
    }

}
