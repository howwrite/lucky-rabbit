package com.github.howwrite.luckyrabbit.domain.valueobject;

import com.github.howwrite.treasure.domain.value.AbstractValueObject;
import com.github.howwrite.treasure.tools.utils.ParameterUtils;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;

@EqualsAndHashCode(callSuper = true)
@Data
public class Session extends AbstractValueObject {
    @Serial
    private static final long serialVersionUID = -1234088993247538511L;
    private String sessionId;

    public Session(String sessionId) {
        ParameterUtils.notBlank("非法请求", sessionId);
        this.sessionId = sessionId;
    }
}
