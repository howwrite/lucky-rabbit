package com.github.howwrite.luckyrabbit.application.aop;

import com.github.howwrite.treasure.server.aop.AbstractServerAspect;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

/**
 * @author howwrite
 * @date 2021/10/10 11:27 上午
 */
@Aspect
@Component
public class ApplicationLogAop extends AbstractServerAspect {
    public ApplicationLogAop(MessageSource messageSource) {
        super(messageSource);
    }

    @Override
    @Pointcut("execution(com.github.howwrite.treasure.api.response.Response com.github.howwrite.luckyrabbit.application.facade.*Impl.*(..))")
    public void apiPointcut() {
    }
}
