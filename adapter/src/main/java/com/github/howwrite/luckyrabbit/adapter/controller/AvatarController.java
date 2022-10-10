package com.github.howwrite.luckyrabbit.adapter.controller;

import com.github.howwrite.luckyrabbit.application.facade.AvatarFacade;
import com.github.howwrite.treasure.api.response.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

import static com.github.howwrite.luckyrabbit.adapter.controller.AvatarController.CONTROLLER_PATH;

/**
 * 头像相关接口声明
 */
@RequiredArgsConstructor
@Controller
@RequestMapping(CONTROLLER_PATH)
public class AvatarController {
    protected static final String CONTROLLER_PATH = "/api/avatar";
    private static final String GET_AVATAR_BY_NAME_PATH = "/avatar-by-name";
    private final AvatarFacade avatarFacade;

    /**
     * 获取模板头像列表
     *
     * @return 系统模板头像地址列表
     */
    @GetMapping("/template-avatar-list")
    @ResponseBody
    public Response<List<String>> avatarTemplateList() {
        List<String> avatarTemplateUrlList = avatarFacade.listAvatarTemplateUrl(CONTROLLER_PATH + GET_AVATAR_BY_NAME_PATH + '/');
        return Response.ok(avatarTemplateUrlList);
    }

    @GetMapping(value = GET_AVATAR_BY_NAME_PATH + "/{name}", produces = {"image/svg+xml"})
    @ResponseBody
    public ResponseEntity<Object> getAvatarByName(@PathVariable String name) {
        // todo 对于 type的处理，还是不能直接返回body，要把所有信息返回在adapter层组装返回结果
        return ResponseEntity.ok(avatarFacade.getAvatarTemplateBodyByName(name));
    }
}
