package com.github.howwrite.luckyrabbit.domain.miap.avatar.model;

import com.github.howwrite.treasure.domain.queryobject.AbstractQuery;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serial;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
public class AvatarTemplateQuery extends AbstractQuery {
    @Serial
    private static final long serialVersionUID = 4651352899341815731L;
    private String name;

    public AvatarTemplateQuery(String name) {
        this.name = name;
    }
}
