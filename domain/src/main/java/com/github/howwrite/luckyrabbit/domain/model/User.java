package com.github.howwrite.luckyrabbit.domain.model;

import com.github.howwrite.luckyrabbit.domain.valueobject.Phone;
import com.github.howwrite.treasure.domain.model.AbstractModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;

@EqualsAndHashCode(callSuper = true)
@Data
public class User extends AbstractModel<Long> {
    @Serial
    private static final long serialVersionUID = -7985465467322413714L;
    /**
     * 昵称
     */
    private String nickname;
    private Phone phone;
    /**
     * 密码
     */
    private String password;
}
