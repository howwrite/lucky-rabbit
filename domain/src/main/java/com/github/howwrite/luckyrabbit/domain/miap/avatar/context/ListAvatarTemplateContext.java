package com.github.howwrite.luckyrabbit.domain.miap.avatar.context;

import com.github.howwrite.luckyrabbit.domain.miap.avatar.model.AvatarTemplate;
import com.github.howwrite.miap.def.MiapReader;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class ListAvatarTemplateContext extends MiapReader<List<AvatarTemplate>> {
    @Serial
    private static final long serialVersionUID = 3521077500036861791L;
    private List<AvatarTemplate> avatarTemplates;

    @Override
    public List<AvatarTemplate> seeTheLast() {
        return avatarTemplates;
    }
}
