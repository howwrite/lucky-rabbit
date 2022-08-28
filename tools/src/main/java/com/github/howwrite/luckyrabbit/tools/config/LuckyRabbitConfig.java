package com.github.howwrite.luckyrabbit.tools.config;

import com.github.howwrite.treasure.properties.helper.BaseProperties;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.boot.context.properties.ConfigurationProperties;

@EqualsAndHashCode(callSuper = true)
@Data
@ConfigurationProperties(prefix = "lucky-rabbit")
public class LuckyRabbitConfig extends BaseProperties {
    /**
     * 图片验证码字符串长度
     */
    private int captchaBodyLength = 4;
    /**
     * 图片验证码有效时间，默认5分钟
     */
    private int captchaLiveMinute = 5;
    /**
     * 短信验证码有效时间，默认5分钟
     */
    private int smsCodeLiveMinute = 5;
    /**
     * 短信验证码长度
     */
    private int smsCodeLength = 4;
    /**
     * 登录状态保存时间
     */
    private int loginStatusLiveToHour = 7 * 24;
}
