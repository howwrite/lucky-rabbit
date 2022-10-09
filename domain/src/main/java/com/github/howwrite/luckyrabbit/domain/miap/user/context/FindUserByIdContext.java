package com.github.howwrite.luckyrabbit.domain.miap.user.context;

import com.github.howwrite.luckyrabbit.domain.miap.user.model.User;
import com.github.howwrite.luckyrabbit.domain.miap.user.model.UserQuery;
import com.github.howwrite.miap.def.MiapReader;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;

import javax.annotation.Nonnull;
import java.io.Serial;

@EqualsAndHashCode(callSuper = true)
@Data
@RequiredArgsConstructor
public class FindUserByIdContext extends MiapReader<User> implements UserContext, UserQueryContext {
    @Serial
    private static final long serialVersionUID = -1344266787128229863L;
    /**
     * 查询的用户信息
     */
    @Nonnull
    private final UserQuery userQuery;
    /**
     * 查询到的用户信息
     */
    private User user;


    @Override
    public User seeTheLast() {
        return user;
    }
}
