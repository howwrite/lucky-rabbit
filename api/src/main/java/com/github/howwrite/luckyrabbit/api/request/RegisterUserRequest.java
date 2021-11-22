package com.github.howwrite.luckyrabbit.api.request;

import com.github.howwrite.luckyrabbit.api.constant.UserErrorCode;
import com.github.howwrite.treasure.api.request.AbstractRequest;
import com.github.howwrite.treasure.common.util.ParameterUtils;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotNull;

/**
 * @author howwrite
 * @date 2021/10/10 10:55 上午
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class RegisterUserRequest extends AbstractRequest {
    private static final long   serialVersionUID = -4713392797268782128L;
    /**
     * 密码
     */
    private              String password;
    /**
     * 昵称
     */
    private              String nickname;
    /**
     * 手机号
     */
    private              String mobile;
    /**
     * 验证码
     */
    private              String verificationCode;

    @Override
    public void checkParam() {
        super.checkParam();
        ParameterUtils.notBlank(UserErrorCode.MOBILE_CAN_NOT_BE_EMPTY, mobile);
    }

    @Override
    public @NotNull String callIntroduction() {
        return "用户注册";
    }
}
