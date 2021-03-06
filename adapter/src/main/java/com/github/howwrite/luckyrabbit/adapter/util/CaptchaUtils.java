package com.github.howwrite.luckyrabbit.adapter.util;

import cn.hutool.captcha.CircleCaptcha;
import cn.hutool.core.codec.Base64Encoder;
import cn.hutool.core.img.ImgUtil;

import java.awt.*;
import java.io.ByteArrayOutputStream;

/**
 * @author howwrite
 * @date 2021/10/11 10:48 下午
 */
public class CaptchaUtils {
    public static String generateCaptchaBase64Str(int width, int height, String code) {
        CircleCaptcha captchaInstance = new CircleCaptcha(width, height, code.length());
        Image image = captchaInstance.createImage(code);

        final ByteArrayOutputStream out = new ByteArrayOutputStream();
        ImgUtil.writePng(image, out);
        byte[] imageBytes = out.toByteArray();
        return Base64Encoder.encode(imageBytes);
    }
}
