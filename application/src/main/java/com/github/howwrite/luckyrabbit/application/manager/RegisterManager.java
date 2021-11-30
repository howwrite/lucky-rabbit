package com.github.howwrite.luckyrabbit.application.manager;

import com.github.howwrite.luckyrabbit.application.dto.UserDTO;
import com.github.howwrite.luckyrabbit.application.endpoint.UserEndpoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author howwrite
 * @date 2021/11/25
 */
@Component
public class RegisterManager {
    private final UserEndpoint userEndpoint;
    @Resource
    private UserManager userManager;

    public RegisterManager(@Autowired(required = false) UserEndpoint userEndpoint) {
        this.userEndpoint = userEndpoint;
    }

    /**
     * 短信验证码注册
     */
    public Long registerBySmsCode(String prefix, String mobile) {
        UserDTO createUserParam = new UserDTO();
        createUserParam.setPrefix(prefix);
        createUserParam.setMobile(mobile);
        createUserParam.setNickname(genNicknameByMobile(mobile));
        return userManager.createUser(createUserParam);
    }

    /**
     * 根据手机号生成默认昵称
     */
    public String genNicknameByMobile(String mobile) {
        if (userEndpoint != null) {
            return userEndpoint.genNicknameByMobile(mobile);
        }
        return mobile;
    }
}
