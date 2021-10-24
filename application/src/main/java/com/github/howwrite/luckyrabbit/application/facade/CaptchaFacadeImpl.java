package com.github.howwrite.luckyrabbit.application.facade;

import com.github.howwrite.luckyrabbit.api.facade.CaptchaFacade;
import com.github.howwrite.luckyrabbit.api.request.GenerateCaptchaRequest;
import com.github.howwrite.luckyrabbit.api.response.GenerateCaptchaInfo;
import com.github.howwrite.luckyrabbit.application.manage.CaptchaManage;
import com.github.howwrite.treasure.api.response.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @author howwrite
 * @date 2021/10/12 8:55 上午
 */
@RequiredArgsConstructor
@Component
public class CaptchaFacadeImpl implements CaptchaFacade {
    private final CaptchaManage captchaManage;

    @Override
    public Response<GenerateCaptchaInfo> generateCaptcha(GenerateCaptchaRequest request) {
        return Response.ok(captchaManage.generateCaptcha(request));
    }
}
