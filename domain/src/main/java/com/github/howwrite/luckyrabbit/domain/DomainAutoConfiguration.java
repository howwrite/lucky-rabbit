package com.github.howwrite.luckyrabbit.domain;

import com.github.howwrite.luckyrabbit.domain.endpoint.DefaultUserEndpoint;
import com.github.howwrite.luckyrabbit.domain.endpoint.UserEndpoint;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@ComponentScan
@Configuration
public class DomainAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean(UserEndpoint.class)
    public UserEndpoint userEndpoint() {
        return new DefaultUserEndpoint();
    }
}
