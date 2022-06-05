package com.github.howwrite.luckyrabbit.infrastructure;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@ComponentScan
@MapperScan(basePackages = "com.github.howwrite.luckyrabbit.infrastructure.mapper")
@Configuration
public class InfrastructureAutoConfiguration {
}
