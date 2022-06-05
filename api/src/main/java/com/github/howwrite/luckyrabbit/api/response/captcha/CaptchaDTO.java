package com.github.howwrite.luckyrabbit.api.response.captcha;

import com.github.howwrite.treasure.api.response.AbstractDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serial;

/**
 * @author howwrite
 * @date 2021/11/20
 */

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CaptchaDTO extends AbstractDTO {
    @Serial
    private static final long serialVersionUID = -1088641924193740057L;
    private String imgBody;
    private String token;
}
