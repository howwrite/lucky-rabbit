package com.github.howwrite.luckyrabbit.infrastructure.mapper;


import com.github.howwrite.luckyrabbit.domain.miap.avatar.model.AvatarTemplateQuery;
import com.github.howwrite.luckyrabbit.infrastructure.dataobject.AvatarTemplateDO;
import org.apache.ibatis.annotations.Mapper;

import javax.annotation.Nonnull;
import java.util.List;

@Mapper
public interface AvatarTemplateMapper {
    @Nonnull
    List<AvatarTemplateDO> list(AvatarTemplateQuery avatarTemplateQuery);

    AvatarTemplateDO get(AvatarTemplateQuery queryParam);
}
