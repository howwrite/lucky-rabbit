package com.github.howwrite.luckyrabbit.api.request.login;

import com.github.howwrite.luckyrabbit.api.constant.SmsCodeSceneEnum;
import com.github.howwrite.treasure.api.request.AbstractRequest;
import com.github.howwrite.treasure.common.util.ParameterUtils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author howwrite
 * @date 2021/10/12 8:42 上午
 */
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Data
public class SendSmsCodeRequest extends AbstractRequest {
    private static final long serialVersionUID = 4809409092045004454L;
    private String prefix;
    private String mobile;
    private String sessionId;
    /**
     * 短信验证码场景
     */
    private SmsCodeSceneEnum scene;

    @Override
    public void checkParam() {
        super.checkParam();
        ParameterUtils.notBlank("手机号不能为空", mobile);
        ParameterUtils.notBlank("手机号不合法", prefix);
        ParameterUtils.notNull("非法请求", scene);
        ParameterUtils.notBlank("非法请求", sessionId);
    }
}
