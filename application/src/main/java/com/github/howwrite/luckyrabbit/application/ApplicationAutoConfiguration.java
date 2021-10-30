package com.github.howwrite.luckyrabbit.application;

import com.github.howwrite.luckyrabbit.application.config.AppProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author howwrite
 * @date 2021/10/10 10:47 上午
 */
@ComponentScan
@Configuration
@EnableConfigurationProperties(AppProperties.class)
public class ApplicationAutoConfiguration {
}
