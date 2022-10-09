package com.github.howwrite.luckyrabbit.domain.miap;

import com.github.howwrite.luckyrabbit.domain.miap.user.node.FindUserByIdNode;
import com.github.howwrite.luckyrabbit.domain.miap.user.node.JudgeLegalUserNode;
import com.github.howwrite.luckyrabbit.domain.miap.user.node.JudgeUserFindParamNode;
import com.github.howwrite.miap.def.MiapBookShelf;
import com.google.common.collect.Lists;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MiapConfiguration {
    @Bean
    public MiapBookShelf findUserById() {
        return new MiapBookShelf(MiapPipelineKeyEnum.FIND_LEGAL_USER.name(), Lists.newArrayList(
                JudgeUserFindParamNode.class,
                FindUserByIdNode.class,
                JudgeLegalUserNode.class
        ));
    }
}
