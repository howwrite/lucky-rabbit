package com.github.howwrite.luckyrabbit.infrastructure.repository;

import com.github.howwrite.luckyrabbit.domain.miap.avatar.model.AvatarTemplate;
import com.github.howwrite.luckyrabbit.domain.miap.avatar.model.AvatarTemplateQuery;
import com.github.howwrite.luckyrabbit.domain.miap.avatar.repository.AvatarTemplateRepository;
import com.github.howwrite.luckyrabbit.infrastructure.dataobject.AvatarTemplateDO;
import com.github.howwrite.luckyrabbit.infrastructure.mapper.AvatarTemplateMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Repository
public class MybatisAvatarTemplateRepository implements AvatarTemplateRepository {
    private final AvatarTemplateMapper avatarTemplateMapper;

    @Nonnull
    @Override
    public List<AvatarTemplate> listAllAvatarTemplate(AvatarTemplateQuery queryParam) {
        return avatarTemplateMapper.list(queryParam).stream().map(AvatarTemplateDO::build2Domain).collect(Collectors.toList());
    }

    @Nullable
    @Override
    public AvatarTemplate getAvatar(AvatarTemplateQuery query) {
        AvatarTemplateDO result = avatarTemplateMapper.get(query);
        if (result == null) {
            return null;
        }
        return result.build2Domain();
    }
}
