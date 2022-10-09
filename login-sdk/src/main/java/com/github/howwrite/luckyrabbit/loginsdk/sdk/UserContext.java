package com.github.howwrite.luckyrabbit.loginsdk.sdk;

import com.github.howwrite.luckyrabbit.api.response.user.UserDTO;

/**
 * @author howwrite
 * @date 2021/9/27 11:04 下午
 */
public class UserContext {
    private static final ThreadLocal<UserDTO> threadUser = new ThreadLocal<>();

    public static void setCurrentUserId(UserDTO user) {
        threadUser.set(user);
    }

    public static UserDTO currentUser() {
        return threadUser.get();
    }

    public static void clear() {
        threadUser.remove();
    }
}
