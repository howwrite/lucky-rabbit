package com.github.howwrite.luckyrabbit.tools;


import com.github.howwrite.luckyrabbit.tools.config.LuckyRabbitConfig;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(LuckyRabbitConfig.class)
public class ToolAutoConfiguration {
}
