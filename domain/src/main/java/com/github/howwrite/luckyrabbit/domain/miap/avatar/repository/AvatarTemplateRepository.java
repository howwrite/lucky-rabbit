package com.github.howwrite.luckyrabbit.domain.miap.avatar.repository;

import com.github.howwrite.luckyrabbit.domain.miap.avatar.model.AvatarTemplate;
import com.github.howwrite.luckyrabbit.domain.miap.avatar.model.AvatarTemplateQuery;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.List;

public interface AvatarTemplateRepository {
    @Nonnull
    List<AvatarTemplate> listAllAvatarTemplate(AvatarTemplateQuery queryParam);

    @Nullable
    AvatarTemplate getAvatar(AvatarTemplateQuery query);
}
