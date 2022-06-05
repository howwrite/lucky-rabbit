package com.github.howwrite.luckyrabbit.domain.queryobject;

import com.github.howwrite.treasure.domain.queryobject.AbstractQuery;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;

/**
 * todo 统一抽象queryParam
 *
 * @author howwrite
 * @date 2021/10/10 10:34 上午
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class UserQuery extends AbstractQuery {
    @Serial
    private static final long serialVersionUID = -6422534039015997754L;
    private Long id;
    private String prefix;
    private String mobile;
    private String nickname;
}
