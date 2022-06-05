package com.github.howwrite.luckyrabbit.adapter.advice;


import com.github.howwrite.treasure.adapter.advice.AbstractAdapterAspect;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AdapterLogAndExceptionAop extends AbstractAdapterAspect {

    public AdapterLogAndExceptionAop(MessageSource messageSource) {
        super(messageSource);
    }

    @Pointcut("execution(com.github.howwrite.treasure.api.response.Response com.github.howwrite.luckyrabbit.adapter.controller.*Controller.*(..))")
    @Override
    public void apiPointcut() {
    }
}
