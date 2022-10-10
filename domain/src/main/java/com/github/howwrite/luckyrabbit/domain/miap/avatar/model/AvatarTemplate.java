package com.github.howwrite.luckyrabbit.domain.miap.avatar.model;

import com.github.howwrite.luckyrabbit.common.constant.AvatarTemplateTypeEnum;
import lombok.Data;

import javax.annotation.Nullable;

@Data
public class AvatarTemplate {
    private String name;
    private AvatarTemplateTypeEnum type;
    private String body;

    @Nullable
    public String buildAvatarUrl(String localImgPathPrefix) {
        if (AvatarTemplateTypeEnum.svg_xml.equals(type)) {
            return localImgPathPrefix + name;
        }
        return null;
    }

    public String buildBody() {
        if (AvatarTemplateTypeEnum.svg_xml.equals(type)) {
            return body;
        }
        return null;
    }
}
