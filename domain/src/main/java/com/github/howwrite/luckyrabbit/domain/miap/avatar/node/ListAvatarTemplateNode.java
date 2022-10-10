package com.github.howwrite.luckyrabbit.domain.miap.avatar.node;

import com.github.howwrite.luckyrabbit.domain.miap.avatar.context.ListAvatarTemplateContext;
import com.github.howwrite.luckyrabbit.domain.miap.avatar.model.AvatarTemplateQuery;
import com.github.howwrite.luckyrabbit.domain.miap.avatar.repository.AvatarTemplateRepository;
import com.github.howwrite.miap.def.MiapBook;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class ListAvatarTemplateNode implements MiapBook<ListAvatarTemplateContext> {
    private final AvatarTemplateRepository avatarTemplateRepository;

    @Override
    public void execute(ListAvatarTemplateContext listAvatarTemplateContext) {
        listAvatarTemplateContext.setAvatarTemplates(avatarTemplateRepository.listAllAvatarTemplate(new AvatarTemplateQuery()));
    }
}
