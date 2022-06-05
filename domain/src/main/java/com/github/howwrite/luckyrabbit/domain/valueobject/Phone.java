package com.github.howwrite.luckyrabbit.domain.valueobject;


import cn.hutool.core.util.PhoneUtil;
import com.github.howwrite.treasure.common.util.ParameterUtils;
import com.github.howwrite.treasure.domain.value.AbstractValueObject;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;


@EqualsAndHashCode(callSuper = true)
@Data
public class Phone extends AbstractValueObject {
    @Serial
    private static final long serialVersionUID = 1038555113021789789L;
    /**
     * 手机号前缀，不带+，不带0，例如86
     */
    private String prefix;
    private String mobile;

    public Phone(String prefix, String mobile) {
        ParameterUtils.assertTrue("请输入正确的手机号", PhoneUtil.isMobile(mobile));
        // todo 处理前缀，暂时使用86
        prefix = "86";
        this.prefix = prefix;
        this.mobile = mobile;
    }
}
