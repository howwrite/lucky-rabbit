package com.github.howwrite.luckyrabbit.adapter;

import com.github.howwrite.luckyrabbit.adapter.config.AdapterProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author howwrite
 * @date 2021/10/11 11:13 下午
 */
@EnableConfigurationProperties(AdapterProperties.class)
@ComponentScan
@Configuration
public class AdapterConfiguration {
}
