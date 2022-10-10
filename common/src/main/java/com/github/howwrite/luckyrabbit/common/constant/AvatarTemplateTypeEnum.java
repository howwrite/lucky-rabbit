package com.github.howwrite.luckyrabbit.common.constant;

import org.apache.commons.lang3.StringUtils;

import javax.annotation.Nullable;

public enum AvatarTemplateTypeEnum {
    svg_xml;

    @Nullable
    public static AvatarTemplateTypeEnum parseByName(String name) {
        if (StringUtils.isBlank(name)) {
            return null;
        }
        for (AvatarTemplateTypeEnum value : values()) {
            if (value.name().equals(name)) {
                return value;
            }
        }
        return null;
    }
}
