package com.github.howwrite.luckyrabbit.api.response;

import com.github.howwrite.treasure.api.response.AbstractInfo;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author howwrite
 * @date 2021/10/10 11:15 上午
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class LoginInfo extends AbstractInfo {
    private static final long   serialVersionUID = -416318749743362284L;
    /**
     * 用户id
     */
    private              Long   userId;
    /**
     * 用户昵称
     */
    private              String nickname;
    /**
     * 用户token
     * 可用此token换取用户信息
     */
    private              String loginToken;
}
