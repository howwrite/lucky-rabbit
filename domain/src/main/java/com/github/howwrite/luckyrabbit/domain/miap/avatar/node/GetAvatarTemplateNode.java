package com.github.howwrite.luckyrabbit.domain.miap.avatar.node;

import com.github.howwrite.luckyrabbit.domain.miap.avatar.context.GetAvatarTemplateContext;
import com.github.howwrite.luckyrabbit.domain.miap.avatar.repository.AvatarTemplateRepository;
import com.github.howwrite.miap.def.MiapBook;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class GetAvatarTemplateNode implements MiapBook<GetAvatarTemplateContext> {
    private final AvatarTemplateRepository avatarTemplateRepository;

    @Override
    public void execute(GetAvatarTemplateContext getAvatarTemplateContext) {
        // todo 要对参数进行校验，否则会有拖库风险
        getAvatarTemplateContext.setGetResult(avatarTemplateRepository.getAvatar(getAvatarTemplateContext.getQueryParam()));
    }
}
