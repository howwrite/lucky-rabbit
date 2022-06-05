package com.github.howwrite.luckyrabbit.common.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 短信验证码场景枚举
 *
 * @author howwrite
 * @date 2021/11/23
 */
@AllArgsConstructor
@Getter
public enum SmsCodeSceneEnum {
    LOGIN("短信登陆");
    private final String sceneDesc;

    public static SmsCodeSceneEnum generate(String sceneName) {
        for (SmsCodeSceneEnum value : values()) {
            if (value.name().equals(sceneName)) {
                return value;
            }
        }
        return null;
    }
}
