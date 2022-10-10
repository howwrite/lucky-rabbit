package com.github.howwrite.luckyrabbit.infrastructure.dataobject;

import com.github.howwrite.luckyrabbit.common.constant.AvatarTemplateTypeEnum;
import com.github.howwrite.luckyrabbit.domain.miap.avatar.model.AvatarTemplate;
import com.github.howwrite.treasure.infrastructure.value.AbstractDO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.annotation.Nonnull;
import java.io.Serial;

@EqualsAndHashCode(callSuper = true)
@Data
public class AvatarTemplateDO extends AbstractDO {
    @Serial
    private static final long serialVersionUID = 81971743480818367L;
    private String name;
    private String type;
    private String body;

    @Nonnull
    public AvatarTemplate build2Domain() {
        AvatarTemplate result = new AvatarTemplate();
        result.setBody(body);
        result.setName(name);
        result.setType(AvatarTemplateTypeEnum.parseByName(type));
        return result;
    }
}
