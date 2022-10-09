package com.github.howwrite.luckyrabbit.domain.miap.user.model;

import com.github.howwrite.luckyrabbit.domain.valueobject.Phone;
import com.github.howwrite.treasure.domain.queryobject.AbstractQuery;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serial;

/**
 * todo 统一抽象queryParam
 *
 * @author howwrite
 * @date 2021/10/10 10:34 上午
 */
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
public class UserQuery extends AbstractQuery {
    @Serial
    private static final long serialVersionUID = -6422534039015997754L;
    private Long id;
    private String nickname;
    private Phone phone;


    public UserQuery(Phone phone) {
        this.phone = phone;
    }

    public UserQuery(Long id) {
        this.id = id;
    }
}
