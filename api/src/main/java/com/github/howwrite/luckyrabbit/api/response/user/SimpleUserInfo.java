package com.github.howwrite.luckyrabbit.api.response.user;

import com.github.howwrite.treasure.api.response.AbstractInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author howwrite
 * @date 2021/11/24
 */
@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SimpleUserInfo extends AbstractInfo {
    private static final long serialVersionUID = 604443932612443327L;
    private Long userId;
    private String nickname;
    private String avatar;
}
