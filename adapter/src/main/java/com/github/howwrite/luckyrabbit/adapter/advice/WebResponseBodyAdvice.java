package com.github.howwrite.luckyrabbit.adapter.advice;

import com.github.howwrite.treasure.web.advice.AbstractResponseBodyAdvice;
import org.springframework.core.MethodParameter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author howwrite
 * @date 2021/11/10
 */
@RestControllerAdvice
public class WebResponseBodyAdvice extends AbstractResponseBodyAdvice {
    @Override
    public boolean supports(@NonNull MethodParameter returnType, @NonNull Class<? extends HttpMessageConverter<?>> converterType) {
        return true;
    }
}
