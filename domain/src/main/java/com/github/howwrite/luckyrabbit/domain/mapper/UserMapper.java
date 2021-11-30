package com.github.howwrite.luckyrabbit.domain.mapper;

import com.github.howwrite.luckyrabbit.domain.dataobject.UserDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author howwrite
 * @date 2021/10/10 10:32 上午
 */
@Mapper
public interface UserMapper {
    void insert(UserDO userDO);

    UserDO findByMobile(String prefix, String mobile);
}
