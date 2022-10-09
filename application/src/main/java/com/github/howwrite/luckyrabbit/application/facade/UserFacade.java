package com.github.howwrite.luckyrabbit.application.facade;

import com.github.howwrite.luckyrabbit.api.request.user.UserQueryParam;
import com.github.howwrite.luckyrabbit.api.response.user.UserDTO;
import com.github.howwrite.luckyrabbit.application.converter.UserAppConverter;
import com.github.howwrite.luckyrabbit.domain.miap.MiapPipelineKeyEnum;
import com.github.howwrite.luckyrabbit.domain.miap.user.context.FindUserByIdContext;
import com.github.howwrite.luckyrabbit.domain.miap.user.model.UserQuery;
import com.github.howwrite.miap.engine.MiapEngine;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @author howwrite
 * @date 2021/10/10 10:49 上午
 */
@RequiredArgsConstructor
@Component
public class UserFacade {

    private final MiapEngine miapEngine;

    public UserDTO findLegalUser(UserQueryParam userQueryParam) {
        FindUserByIdContext findUserByIdContext = new FindUserByIdContext(new UserQuery(userQueryParam.getUserId()));
        return UserAppConverter.domain2DTO(miapEngine.invoke(MiapPipelineKeyEnum.FIND_LEGAL_USER.name(), findUserByIdContext));
    }
}
