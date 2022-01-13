package com.github.howwrite.luckyrabbit.loginsdk;

import com.github.howwrite.luckyrabbit.api.facade.LoginFacade;
import com.github.howwrite.luckyrabbit.loginsdk.config.LoginSdkProperties;
import com.github.howwrite.luckyrabbit.loginsdk.helper.LoginSessionDecodeHelper;
import com.github.howwrite.luckyrabbit.loginsdk.interceptor.UserInterceptor;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author howwrite
 * @date 2021/11/27
 */
@RequiredArgsConstructor
@ComponentScan
@Configuration
@EnableConfigurationProperties(LoginSdkProperties.class)
public class LuckyRabbitLoginSdkConfiguration implements WebMvcConfigurer {
    private final LoginFacade loginFacade;
    private final LoginSessionDecodeHelper loginSessionDecodeHelper;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new UserInterceptor(loginFacade, loginSessionDecodeHelper))
                .addPathPatterns("/api/**")
                .excludePathPatterns("/api/login/by-sms-code", "/api/sms/send", "/api/captcha/**");
    }
}
