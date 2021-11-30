package com.github.howwrite.luckyrabbit.api.request.login;

import com.github.howwrite.treasure.api.request.AbstractRequest;
import com.github.howwrite.treasure.common.util.ParameterUtils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author howwrite
 * @date 2021/11/30
 */
@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FindUserByLoginTokenRequest extends AbstractRequest {
    private static final long serialVersionUID = -1808831943353205535L;
    private String loginToken;

    @Override
    public void checkParam() {
        super.checkParam();
        ParameterUtils.notBlank("token不可为空", loginToken);
    }
}
