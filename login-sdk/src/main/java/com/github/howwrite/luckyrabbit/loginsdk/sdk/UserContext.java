package com.github.howwrite.luckyrabbit.loginsdk.sdk;

/**
 * @author howwrite
 * @date 2021/9/27 11:04 下午
 */
public class UserContext {
    public static final ThreadLocal<Long> threadUser = new ThreadLocal<>();

    public static void setCurrentUserId(Long userId) {
        threadUser.set(userId);
    }

    public static Long currentUserId() {
        return threadUser.get();
    }
}
