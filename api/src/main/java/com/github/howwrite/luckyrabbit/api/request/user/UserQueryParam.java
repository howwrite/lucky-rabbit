package com.github.howwrite.luckyrabbit.api.request.user;

import com.github.howwrite.treasure.api.request.AbstractRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serial;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
public class UserQueryParam extends AbstractRequest {
    @Serial
    private static final long serialVersionUID = -7831387545485701838L;
    /**
     * 用户id
     */
    private Long userId;

    public UserQueryParam(Long userId) {
        this.userId = userId;
    }
}
