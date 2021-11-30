package com.github.howwrite.luckyrabbit.loginsdk.config;

import com.github.howwrite.treasure.properties.helper.BaseProperties;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author howwrite
 * @date 2021/11/27
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ConfigurationProperties(prefix = "lucky-rabbit.login")
public class LoginSdkProperties extends BaseProperties {
    /**
     * 登录cookie名称
     */
    private String loginCookieName = "lucky-rabbit";
}
