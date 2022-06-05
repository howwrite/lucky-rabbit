package com.github.howwrite.luckyrabbit.domain.valueobject;

import com.github.howwrite.treasure.domain.value.AbstractValueObject;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;
import java.util.Optional;

@EqualsAndHashCode(callSuper = true)
@Data
public class CaptchaSize extends AbstractValueObject {
    public static final int DEFAULT_WIDTH = 150;
    public static final int DEFAULT_HEIGHT = 200;
    @Serial
    private static final long serialVersionUID = -6392666412804132949L;
    private int width;
    private int height;

    public CaptchaSize(Integer width, Integer height) {
        this.width = Optional.ofNullable(width).orElse(DEFAULT_WIDTH);
        this.height = Optional.ofNullable(height).orElse(DEFAULT_HEIGHT);
    }
}
