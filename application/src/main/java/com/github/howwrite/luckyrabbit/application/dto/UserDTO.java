package com.github.howwrite.luckyrabbit.application.dto;

import com.github.howwrite.treasure.common.dto.AbstractDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author howwrite
 * @date 2021/11/25
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class UserDTO extends AbstractDTO {
    private static final long serialVersionUID = -8422139519520374189L;
    private Long id;
    private String nickname;
    private String mobile;
    private String prefix;
    private String password;
}
