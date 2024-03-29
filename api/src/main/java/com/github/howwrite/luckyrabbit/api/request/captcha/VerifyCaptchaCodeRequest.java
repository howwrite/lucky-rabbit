package com.github.howwrite.luckyrabbit.api.request.captcha;

import com.github.howwrite.treasure.api.request.AbstractRequest;
import com.github.howwrite.treasure.tools.utils.ParameterUtils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serial;

/**
 * @author howwrite
 * @date 2021/11/22
 */
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
public class VerifyCaptchaCodeRequest extends AbstractRequest {
    @Serial
    private static final long serialVersionUID = -975305081864426417L;
    private String captchaCode;
    private String sessionId;
    private String captchaToken;

    @Override
    public void checkParam() {
        super.checkParam();
        ParameterUtils.notBlank("验证码不可为空", captchaCode)
                .notBlank("非法校验请求", sessionId)
                .notBlank("请获取验证码", captchaToken);
    }
}
