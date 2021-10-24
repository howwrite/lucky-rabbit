package com.github.howwrite.luckyrabbit.domain.queryobject;

import lombok.Data;

import java.io.Serializable;

/**
 * todo 统一抽象queryParam
 *
 * @author howwrite
 * @date 2021/10/10 10:34 上午
 */
@Data
public class UserQueryParam implements Serializable {
    private Long   id;
    private String mobile;
    private String nickname;
}
