package com.github.howwrite.luckyrabbit.application.config;

import com.github.howwrite.treasure.properties.helper.BaseProperties;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.boot.context.properties.ConfigurationProperties;

@EqualsAndHashCode(callSuper = true)
@Data
@ConfigurationProperties(prefix = "lucky-rabbit.app")
public class AppProperties extends BaseProperties {
    private int captchaBodyLength = 4;
    /**
     * 图片验证码有效时间，默认5分钟
     */
    private int captchaLiveMinute = 5;
}
