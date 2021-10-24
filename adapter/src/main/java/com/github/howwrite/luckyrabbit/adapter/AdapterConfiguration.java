package com.github.howwrite.luckyrabbit.adapter;

import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author howwrite
 * @date 2021/10/11 11:13 下午
 */
@ConfigurationPropertiesScan("com.github.howwrite.luckyrabbit.adapter.config")
@ComponentScan
@Configuration
public class AdapterConfiguration {
}
