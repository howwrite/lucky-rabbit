package com.github.howwrite.luckyrabbit.domain.miap.user.node;

import com.github.howwrite.luckyrabbit.domain.miap.user.context.UserContext;
import com.github.howwrite.luckyrabbit.domain.miap.user.model.User;
import com.github.howwrite.miap.def.MiapBook;
import org.springframework.stereotype.Component;

/**
 * 判断用户是否合法
 */
@Component
public class JudgeLegalUserNode implements MiapBook<UserContext> {
    @Override
    public void execute(UserContext userContext) {
        User user = userContext.getUser();
        // 用户合法性判断
    }
}
