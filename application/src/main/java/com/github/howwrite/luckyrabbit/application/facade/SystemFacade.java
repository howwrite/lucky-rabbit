package com.github.howwrite.luckyrabbit.application.facade;

import com.github.howwrite.luckyrabbit.domain.config.LuckyRabbitSystemProperties;
import com.google.common.collect.Lists;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.List;

@RequiredArgsConstructor
@Component
public class SystemFacade {
    private final LuckyRabbitSystemProperties luckyRabbitSystemProperties;

    public List<String> supportMobilePrefix() {
        return CollectionUtils.isEmpty(luckyRabbitSystemProperties.getSupportMobilePrefix()) ? Lists.newArrayList("+86") : luckyRabbitSystemProperties.getSupportMobilePrefix();
    }

}
