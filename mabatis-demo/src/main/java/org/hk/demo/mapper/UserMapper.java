package org.hk.demo.mapper;

import org.apache.ibatis.annotations.Param;
import org.hk.demo.entity.UserEntity;

public interface UserMapper {
    UserEntity findById(@Param("id") int id);
}
