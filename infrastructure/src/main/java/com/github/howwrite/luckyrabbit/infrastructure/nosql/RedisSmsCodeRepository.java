package com.github.howwrite.luckyrabbit.infrastructure.nosql;

import com.github.howwrite.luckyrabbit.common.constant.SmsCodeSceneEnum;
import com.github.howwrite.luckyrabbit.domain.repository.SmsCodeRepository;
import com.github.howwrite.luckyrabbit.domain.valueobject.Phone;
import com.github.howwrite.luckyrabbit.domain.valueobject.Session;
import com.github.howwrite.treasure.common.exception.ServerBizException;
import com.google.common.collect.Lists;
import lombok.RequiredArgsConstructor;
import org.redisson.api.RBucket;
import org.redisson.api.RScript;
import org.redisson.api.RedissonClient;
import org.springframework.stereotype.Repository;

import java.util.concurrent.TimeUnit;

/**
 * @author howwrite
 * @date 2021/11/23
 */
@RequiredArgsConstructor
@Repository
public class RedisSmsCodeRepository implements SmsCodeRepository {
    public static final String SMS_CODE_DB_NAME = "lucky_rabbit_sms_code:";
    private final RedissonClient redissonClient;

    public boolean bindSmsCode(Session session, Phone phone, SmsCodeSceneEnum sceneEnum, String smsCode, int minuteToLive) {
        RBucket<String> bucket = redissonClient.getBucket(genSmsCodeDataKey(session, phone, sceneEnum));
        bucket.set(smsCode, minuteToLive, TimeUnit.MINUTES);
        return true;
    }

    public boolean verifySmsCode(Session session, Phone phone, SmsCodeSceneEnum sceneEnum, String smsCode) {
        RBucket<String> bucket = redissonClient.getBucket(genSmsCodeDataKey(session, phone, sceneEnum));
        String realSmsCode = bucket.get();
        if (realSmsCode == null || !realSmsCode.equals(smsCode)) {
            throw new ServerBizException("短信验证码错误");
        }
        return bucket.delete();
    }

    /**
     * 查询用户的短信验证码，查找到就续期并返回，没找到就返回null
     */
    public String findSmsCode(Session session, Phone phone, SmsCodeSceneEnum sceneEnum, int minuteToLive) {
        int secondToLive = minuteToLive * 60;
        String dataKey = genSmsCodeDataKey(session, phone, sceneEnum);
        String luaScript = """
                local data = redis.call('GET',KEYS[1]);
                if data then
                redis.call('EXPIRE',KEYS[1],ARGV[1]);
                return data;
                end;
                return nil;""";
        RScript script = redissonClient.getScript();
        return script.eval(RScript.Mode.READ_WRITE, luaScript, RScript.ReturnType.VALUE, Lists.newArrayList(dataKey), secondToLive);

    }


    public String genSmsCodeDataKey(Session session, Phone phone, SmsCodeSceneEnum scene) {
        return SMS_CODE_DB_NAME + session.getSessionId() + phone.getPrefix() + phone.getMobile() + scene.name();
    }
}
