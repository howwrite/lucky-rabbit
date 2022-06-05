package com.github.howwrite.luckyrabbit.domain.model;

import com.github.howwrite.luckyrabbit.domain.valueobject.Session;
import com.github.howwrite.treasure.domain.model.AbstractModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;

@EqualsAndHashCode(callSuper = true)
@Data
public class Captcha extends AbstractModel<String> {
    @Serial
    private static final long serialVersionUID = 1262692466193188099L;
    /**
     * 验证码token
     */
    private String captchaToken;
    /**
     * 验证码内容
     */
    private String captchaBody;

    /**
     * 有效时间 单位分钟
     */
    private long minuteToLive;
    /**
     * 关联的session信息
     */
    private Session session;

    public Captcha(String captchaToken, String captchaBody, long minuteToLive, Session session) {
        this.captchaToken = captchaToken;
        this.captchaBody = captchaBody;
        this.minuteToLive = minuteToLive;
        this.session = session;
    }

    public Captcha(String captchaToken, String captchaBody, Session session) {
        this.captchaToken = captchaToken;
        this.captchaBody = captchaBody;
        this.session = session;
    }
}
