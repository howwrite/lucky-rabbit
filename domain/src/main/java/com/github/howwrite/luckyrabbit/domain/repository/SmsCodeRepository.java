package com.github.howwrite.luckyrabbit.domain.repository;

import com.github.howwrite.luckyrabbit.common.constant.SmsCodeSceneEnum;
import com.github.howwrite.luckyrabbit.domain.valueobject.Phone;
import com.github.howwrite.luckyrabbit.domain.valueobject.Session;

public interface SmsCodeRepository {
    String findSmsCode(Session session, Phone phone, SmsCodeSceneEnum sceneEnum, int minuteToLive);

    boolean bindSmsCode(Session session, Phone phone, SmsCodeSceneEnum sceneEnum, String smsCode, int minuteToLive);

    boolean verifySmsCode(Session session, Phone phone, SmsCodeSceneEnum sceneEnum, String smsCode);
}
