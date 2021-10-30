package com.github.howwrite.luckyrabbit.api.response;

import com.github.howwrite.treasure.api.response.AbstractInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author howwrite
 * @date 2021/10/12 8:46 上午
 */
@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GenerateCaptchaInfo extends AbstractInfo {
    private static final long serialVersionUID = 1262692466193188099L;
    /**
     * 验证码token
     */
    private String captchaToken;
    /**
     * 验证码内容
     */
    private String captchaBody;
}
