package com.github.howwrite.luckyrabbit.domain.miap.user.node;

import com.github.howwrite.luckyrabbit.domain.miap.user.context.UserQueryContext;
import com.github.howwrite.luckyrabbit.domain.miap.user.model.UserQuery;
import com.github.howwrite.miap.def.MiapBook;
import com.github.howwrite.treasure.common.exception.ServerBizException;
import org.springframework.stereotype.Component;

/**
 * 判断查询单个用户请求参数是否合法
 */
@Component
public class JudgeUserFindParamNode implements MiapBook<UserQueryContext> {

    @Override
    public void execute(UserQueryContext userQueryContext) {
        UserQuery userQuery = userQueryContext.getUserQuery();
        if (userQuery == null) {
            throw new ServerBizException("请求错误");
        }
        if (userQuery.getId() == null && userQuery.getPhone() == null && userQuery.getNickname() == null) {
            throw new ServerBizException("查询失败，无查询条件");
        }
    }
}
