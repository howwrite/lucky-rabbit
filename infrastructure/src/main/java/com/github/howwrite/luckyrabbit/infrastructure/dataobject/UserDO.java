package com.github.howwrite.luckyrabbit.infrastructure.dataobject;

import com.github.howwrite.luckyrabbit.domain.model.User;
import com.github.howwrite.luckyrabbit.domain.valueobject.Phone;
import com.github.howwrite.treasure.infrastructure.value.AbstractDO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.annotation.Nonnull;
import java.io.Serial;

/**
 * @author howwrite
 * @date 2021/10/10 9:40 上午
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class UserDO extends AbstractDO<Long> {
    @Serial
    private static final long serialVersionUID = -5928709396881136757L;
    /**
     * 昵称
     */
    private String nickname;
    /**
     * 手机号
     */
    private String mobile;
    /**
     * 手机号前缀
     */
    private String prefix;
    /**
     * 密码
     */
    private String password;

    public static UserDO buildByDomain(@Nonnull User domain) {
        UserDO userDO = new UserDO();
        userDO.setNickname(domain.getNickname());
        userDO.setMobile(domain.getPhone().getMobile());
        userDO.setPrefix(domain.getPhone().getPrefix());
        userDO.setPassword(domain.getPassword());
        userDO.setId(domain.getId());
        userDO.setDeleted(0L);
        return userDO;
    }

    public @Nonnull User build2Domain() {
        User user = new User();
        user.setNickname(nickname);
        user.setPassword(password);
        user.setPhone(new Phone(prefix, mobile));
        return user;
    }
}
