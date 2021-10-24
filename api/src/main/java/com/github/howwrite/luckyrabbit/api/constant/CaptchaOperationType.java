package com.github.howwrite.luckyrabbit.api.constant;

import com.github.howwrite.treasure.api.constant.OperationType;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * @author howwrite
 * @date 2021/10/12 8:43 上午
 */
@Getter
@RequiredArgsConstructor
public enum CaptchaOperationType implements OperationType {
    GENERATE_CAPTCHA(true, "生成图形验证码"),
    ;
    private final boolean write;
    private final String  introduction;
}
