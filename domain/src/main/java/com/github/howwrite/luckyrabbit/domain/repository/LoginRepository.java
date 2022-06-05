package com.github.howwrite.luckyrabbit.domain.repository;

public interface LoginRepository {
    Long findUserIdByToken(String token);

    boolean bindLoginToken(String token, Long userId, int hourToLive);
}
