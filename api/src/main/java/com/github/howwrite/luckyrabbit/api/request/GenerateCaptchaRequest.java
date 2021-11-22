package com.github.howwrite.luckyrabbit.api.request;

import com.github.howwrite.treasure.api.request.AbstractRequest;
import com.github.howwrite.treasure.common.util.ParameterUtils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

/**
 * @author howwrite
 * @date 2021/10/12 8:42 上午
 */
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Data
public class GenerateCaptchaRequest extends AbstractRequest {
    private static final long serialVersionUID = 4809409092045004454L;
    private String sessionId;
    private Integer width;
    private Integer height;

    @Override
    public @NotNull String callIntroduction() {
        return "生成图形验证码";
    }

    @Override
    public void checkParam() {
        super.checkParam();
        ParameterUtils.notNull("验证码宽度不可为空", width);
        ParameterUtils.notNull("验证码高度不可为空", height);
        ParameterUtils.notBlank("非法校验请求", sessionId);
    }
}
