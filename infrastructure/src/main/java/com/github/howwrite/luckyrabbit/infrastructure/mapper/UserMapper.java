package com.github.howwrite.luckyrabbit.infrastructure.mapper;

import com.github.howwrite.luckyrabbit.domain.queryobject.UserQuery;
import com.github.howwrite.luckyrabbit.infrastructure.dataobject.UserDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author howwrite
 * @date 2021/10/10 10:32 上午
 */
@Mapper
public interface UserMapper {
    void insert(UserDO userDO);

    UserDO get(UserQuery userQuery);

    List<UserDO> list(UserQuery userQuery);
}
