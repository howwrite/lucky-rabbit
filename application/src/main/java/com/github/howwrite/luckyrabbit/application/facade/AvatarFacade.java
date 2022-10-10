package com.github.howwrite.luckyrabbit.application.facade;

import com.github.howwrite.luckyrabbit.domain.miap.MiapPipelineKeyEnum;
import com.github.howwrite.luckyrabbit.domain.miap.avatar.context.GetAvatarTemplateContext;
import com.github.howwrite.luckyrabbit.domain.miap.avatar.context.ListAvatarTemplateContext;
import com.github.howwrite.luckyrabbit.domain.miap.avatar.model.AvatarTemplate;
import com.github.howwrite.luckyrabbit.domain.miap.avatar.model.AvatarTemplateQuery;
import com.github.howwrite.miap.engine.MiapEngine;
import com.github.howwrite.treasure.common.exception.ServerBizException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Component
@RequiredArgsConstructor
public class AvatarFacade {

    private final MiapEngine miapEngine;

    /**
     * 获取头像模板列表
     *
     * @param localImgPathPrefix 本地图片地址前缀
     * @return 头像模板列表
     */
    public List<String> listAvatarTemplateUrl(String localImgPathPrefix) {
        ListAvatarTemplateContext listAvatarTemplateContext = new ListAvatarTemplateContext();
        return miapEngine.invoke(MiapPipelineKeyEnum.List_AVATAR_TEMPLATE.name(), listAvatarTemplateContext).stream().map(it -> it.buildAvatarUrl(localImgPathPrefix)).collect(Collectors.toList());
    }

    public String getAvatarTemplateBodyByName(String avatarTemplateName) {
        GetAvatarTemplateContext getAvatarTemplateContext = new GetAvatarTemplateContext(new AvatarTemplateQuery(avatarTemplateName));
        AvatarTemplate avatarTemplate = miapEngine.invoke(MiapPipelineKeyEnum.GET_AVATAR_TEMPLATE.name(), getAvatarTemplateContext);
        if (avatarTemplate == null) {
            log.error("图片模板不存在, name:{}", avatarTemplateName);
            throw new ServerBizException("图片模板不存在");
        }
        return avatarTemplate.buildBody();
    }
}
