package com.github.howwrite.luckyrabbit.loginsdk;

import com.github.howwrite.luckyrabbit.api.service.LoginService;
import com.github.howwrite.luckyrabbit.api.service.UserService;
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
    private final LoginService loginFacade;
    private final LoginSessionDecodeHelper loginSessionDecodeHelper;

    private final UserService userService;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new UserInterceptor(loginFacade, loginSessionDecodeHelper, userService))
                .addPathPatterns("/api/**")
                .excludePathPatterns(
                        "/api/login/by-sms-code",
                        "/api/sms/send",
                        "/api/captcha/**",
                        "/api/system/support-mobile-prefix");
    }
}
