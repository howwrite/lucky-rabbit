package com.github.howwrite.luckyrabbit.domain.valueobject;

import com.github.howwrite.treasure.domain.value.AbstractValueObject;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;

/**
 * 登录因子，包含登录token和保存时间
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class LoginFactor extends AbstractValueObject {
    @Serial
    private static final long serialVersionUID = -6872646504538101193L;

    /**
     * 登录token，对应redis中的key
     */
    private String loginToken;
    /**
     * 登录态保存时间
     */
    private Integer hourToLive;

    public LoginFactor(String loginToken, Integer hourToLive) {
        this.loginToken = loginToken;
        this.hourToLive = hourToLive;
    }
}
