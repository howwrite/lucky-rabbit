package com.github.howwrite.luckyrabbit.domain.config;

import com.github.howwrite.treasure.properties.helper.BaseProperties;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@ConfigurationProperties(prefix = "lucky-rabbit.system")
public class LuckyRabbitSystemProperties extends BaseProperties {
    /**
     * 支持的手机号前缀
     */
    private List<String> supportMobilePrefix;
}
