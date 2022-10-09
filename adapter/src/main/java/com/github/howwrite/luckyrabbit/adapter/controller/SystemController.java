package com.github.howwrite.luckyrabbit.adapter.controller;

import com.github.howwrite.luckyrabbit.application.facade.SystemFacade;
import com.github.howwrite.treasure.api.response.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/system")
public class SystemController {

    private final SystemFacade systemFacade;

    @GetMapping("/support-mobile-prefix")
    public Response<List<String>> supportMobilePrefix() {
        return Response.ok(systemFacade.supportMobilePrefix());
    }

}
