package com.github.howwrite.luckyrabbit.api.request.login;

import com.github.howwrite.treasure.api.request.AbstractRequest;
import com.github.howwrite.treasure.tools.utils.ParameterUtils;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;

/**
 * @author howwrite
 * @date 2021/11/24
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class LoginBySmsCodeRequest extends AbstractRequest {
    @Serial
    private static final long serialVersionUID = -5784388867333342827L;
    private String prefix;
    private String mobile;
    private String smsCode;
    private String sessionId;

    @Override
    public void checkParam() {
        super.checkParam();
        ParameterUtils.notBlank("手机号格式有误", prefix)
                .notBlank("手机号不可为空", mobile)
                .notBlank("请输入短信验证码", smsCode);
    }
}
