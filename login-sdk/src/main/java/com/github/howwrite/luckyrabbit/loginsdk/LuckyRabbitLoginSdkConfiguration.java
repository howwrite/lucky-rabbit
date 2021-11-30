package com.github.howwrite.luckyrabbit.loginsdk;

import com.github.howwrite.luckyrabbit.api.facade.LoginFacade;
import com.github.howwrite.luckyrabbit.loginsdk.config.LoginSdkProperties;
import com.github.howwrite.luckyrabbit.loginsdk.filter.UserFilter;
import com.github.howwrite.luckyrabbit.loginsdk.helper.LoginSessionDecodeHelper;
import com.google.common.collect.Lists;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author howwrite
 * @date 2021/11/27
 */
@ComponentScan
@Configuration
@EnableConfigurationProperties(LoginSdkProperties.class)
public class LuckyRabbitLoginSdkConfiguration {
    @Bean
    public FilterRegistrationBean<UserFilter> thirdFilter(LoginFacade loginFacade, LoginSessionDecodeHelper loginSessionDecodeHelper) {
        UserFilter userFilter = new UserFilter(loginFacade, loginSessionDecodeHelper);
        FilterRegistrationBean<UserFilter> filterRegistrationBean = new FilterRegistrationBean<>();
        filterRegistrationBean.setFilter(userFilter);
        filterRegistrationBean.setUrlPatterns(Lists.newArrayList("/*"));
        return filterRegistrationBean;
    }
}
