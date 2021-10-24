package com.github.howwrite.luckyrabbit.api.constant;

import com.github.howwrite.treasure.api.constant.OperationType;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author howwrite
 * @date 2021/10/10 10:56 上午
 */
@Getter
@AllArgsConstructor
public enum UserOperationType implements OperationType {
    REGISTER_USER(true, "用户注册请求");
    private final boolean write;
    private final String  introduction;
}
