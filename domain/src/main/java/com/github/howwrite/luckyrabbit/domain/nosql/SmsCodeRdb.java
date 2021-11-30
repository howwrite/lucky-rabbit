package com.github.howwrite.luckyrabbit.domain.nosql;

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
public class SmsCodeRdb {
    public static final String SMS_CODE_DB_NAME = "lucky_rabbit_sms_code:";
    private final RedissonClient redissonClient;

    public boolean bindSmsCode(String sessionId, String prefix, String mobile, String smsCodeScene, String smsCode, int minuteToLive) {
        RBucket<String> bucket = redissonClient.getBucket(genSmsCodeDataKey(sessionId, prefix, mobile, smsCodeScene));
        bucket.set(smsCode, minuteToLive, TimeUnit.MINUTES);
        return true;
    }

    public boolean verifySmsCode(String sessionId, String prefix, String mobile, String smsCodeScene, String smsCode) {
        RBucket<String> bucket = redissonClient.getBucket(genSmsCodeDataKey(sessionId, prefix, mobile, smsCodeScene));
        String realSmsCode = bucket.get();
        if (realSmsCode == null || !realSmsCode.equals(smsCode)) {
            throw new ServerBizException("短信验证码错误");
        }
        return bucket.delete();
    }

    /**
     * 查询用户的短信验证码，查找到就续期并返回，没找到就返回null
     */
    public String findSmsCode(String sessionId, String prefix, String mobile, String smsCodeScene, int minuteToLive) {
        int secondToLive = minuteToLive * 60;
        String dataKey = genSmsCodeDataKey(sessionId, prefix, mobile, smsCodeScene);
        String luaScript = "local data = redis.call('GET',KEYS[1]);\n" +
                "if data then\n" +
                "redis.call('EXPIRE',KEYS[1],ARGV[1]);\n" +
                "return data;\n" +
                "end;\n" +
                "return nil;";
        RScript script = redissonClient.getScript();
        return script.eval(RScript.Mode.READ_WRITE, luaScript, RScript.ReturnType.VALUE, Lists.newArrayList(dataKey), secondToLive);

    }


    public String genSmsCodeDataKey(String sessionId, String prefix, String mobile, String smsCodeScene) {
        return SMS_CODE_DB_NAME + sessionId + prefix + mobile + smsCodeScene;
    }
}
