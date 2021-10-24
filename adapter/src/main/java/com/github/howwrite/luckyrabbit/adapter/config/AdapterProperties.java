package com.github.howwrite.luckyrabbit.adapter.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author howwrite
 * @date 2021/10/12 8:37 上午
 */
@Data
@ConfigurationProperties(prefix = "lucky-rabbit.adapter")
public class AdapterProperties {
    /**
     * 图形验证码宽度
     */
    private int captchaWidth  = 300;
    /**
     * 图形验证码高度
     */
    private int captchaHeight = 150;
}
