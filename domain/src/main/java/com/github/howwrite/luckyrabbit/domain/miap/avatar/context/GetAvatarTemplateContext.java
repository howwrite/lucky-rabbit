package com.github.howwrite.luckyrabbit.domain.miap.avatar.context;

import com.github.howwrite.luckyrabbit.domain.miap.avatar.model.AvatarTemplate;
import com.github.howwrite.luckyrabbit.domain.miap.avatar.model.AvatarTemplateQuery;
import com.github.howwrite.miap.def.MiapReader;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;

import java.io.Serial;

@RequiredArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Data
public class GetAvatarTemplateContext extends MiapReader<AvatarTemplate> {
    @Serial
    private static final long serialVersionUID = 1845320277082945460L;

    private final AvatarTemplateQuery queryParam;
    private AvatarTemplate getResult;

    @Override
    public AvatarTemplate seeTheLast() {
        return getResult;
    }
}
