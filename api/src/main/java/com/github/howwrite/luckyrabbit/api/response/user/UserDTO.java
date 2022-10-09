package com.github.howwrite.luckyrabbit.api.response.user;

import com.github.howwrite.treasure.api.response.AbstractDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.annotation.Nonnull;
import java.io.Serial;

@EqualsAndHashCode(callSuper = true)
@Data
public class UserDTO extends AbstractDTO {
    @Serial
    private static final long serialVersionUID = -5928709396881136757L;
    /**
     * 昵称
     */
    @Nonnull
    private String nickname;
    /**
     * 手机号前缀
     */
    @Nonnull
    private String prefix;
    /**
     * 手机号
     */
    @Nonnull
    private String mobile;
    /**
     * 头像地址
     */
    private String avatarUrl;
}
