package org.hk.demo.mapper;

import org.apache.ibatis.annotations.Param;
import org.hk.demo.entity.InformationEntity;

public interface InformationMapper {
    InformationEntity findById(@Param("id") int id);
}
