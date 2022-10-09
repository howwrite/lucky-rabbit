package com.github.howwrite.luckyrabbit.adapter.provider;

import com.github.howwrite.luckyrabbit.api.request.user.UserQueryParam;
import com.github.howwrite.luckyrabbit.api.response.user.UserDTO;
import com.github.howwrite.luckyrabbit.api.service.UserService;
import com.github.howwrite.luckyrabbit.application.facade.UserFacade;
import com.github.howwrite.treasure.api.response.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {
    private final UserFacade userFacade;

    @Override
    public Response<UserDTO> findLegalUser(UserQueryParam userQueryParam) {
        return Response.ok(userFacade.findLegalUser(userQueryParam));
    }
}
