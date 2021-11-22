package com.github.howwrite.luckyrabbit.adapter.advice;

import com.github.howwrite.treasure.web.advice.AbstractExceptionAdvice;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author howwrite
 * @date 2021/11/10
 */
@RestControllerAdvice
public class WebExceptionAdvice extends AbstractExceptionAdvice {
    public WebExceptionAdvice(MessageSource messageSource) {
        super(messageSource);
    }
}
