package com.github.howwrite.luckyrabbit.api.response.avatar;

import com.github.howwrite.treasure.api.response.AbstractDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;

@EqualsAndHashCode(callSuper = true)
@Data
public class AvatarTemplateDTO extends AbstractDTO {
    @Serial
    private static final long serialVersionUID = -5507014376699735907L;
    private String name;
    private String type;
    private String body;
}
