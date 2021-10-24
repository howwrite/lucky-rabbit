package com.github.howwrite.luckyrabbit.api.request;

import com.github.howwrite.luckyrabbit.api.constant.CaptchaOperationType;
import com.github.howwrite.treasure.api.constant.OperationType;
import com.github.howwrite.treasure.api.request.AbstractRequest;
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
    private static final long   serialVersionUID = 4809409092045004454L;
    private              String sessionId;

    @Override
    public @NotNull OperationType callOperationType() {
        return CaptchaOperationType.GENERATE_CAPTCHA;
    }
}
