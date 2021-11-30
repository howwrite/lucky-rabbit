package com.github.howwrite.luckyrabbit.api.response.login;

import com.github.howwrite.treasure.api.response.AbstractInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author howwrite
 * @date 2021/11/27
 */
@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserLoginInfo extends AbstractInfo {
    private static final long serialVersionUID = -4442628640427787076L;
    /**
     * 登录token，对应redis中的key
     */
    private String loginToken;
    /**
     * 登录态保存时间
     */
    private Integer hourToLive;
}
