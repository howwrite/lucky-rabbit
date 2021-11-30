package com.github.howwrite.luckyrabbit.api.request.login;

import com.github.howwrite.treasure.api.request.AbstractRequest;
import com.github.howwrite.treasure.common.util.ParameterUtils;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author howwrite
 * @date 2021/11/24
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class LoginBySmsCodeRequest extends AbstractRequest {
    private static final long serialVersionUID = -5784388867333342827L;
    private String prefix;
    private String mobile;
    private String smsCode;
    private Boolean autoLogin;
    private String sessionId;

    @Override
    public void checkParam() {
        super.checkParam();
        ParameterUtils.notBlank("手机号格式有误", prefix);
        ParameterUtils.notBlank("手机号不可为空", mobile);
        ParameterUtils.notBlank("请输入短信验证码", smsCode);
        ParameterUtils.notBlank("非法请求", sessionId);
    }
}
