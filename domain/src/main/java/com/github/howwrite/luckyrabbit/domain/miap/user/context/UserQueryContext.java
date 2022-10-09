package com.github.howwrite.luckyrabbit.domain.miap.user.context;

import com.github.howwrite.luckyrabbit.domain.miap.user.model.UserQuery;
import com.github.howwrite.miap.def.MiapPreface;

public interface UserQueryContext extends MiapPreface {
    UserQuery getUserQuery();
}
