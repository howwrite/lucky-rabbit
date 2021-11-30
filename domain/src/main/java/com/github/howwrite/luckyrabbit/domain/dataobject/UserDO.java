package com.github.howwrite.luckyrabbit.domain.dataobject;

import com.github.howwrite.treasure.domain.AbstractDO;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author howwrite
 * @date 2021/10/10 9:40 上午
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class UserDO extends AbstractDO<Long> {
    private static final long serialVersionUID = -5928709396881136757L;
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
    /**
     * 昵称
     */
    private String nickname;
}
