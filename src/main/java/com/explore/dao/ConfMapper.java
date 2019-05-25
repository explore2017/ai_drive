package com.explore.dao;

import com.explore.pojo.Conf;
import org.apache.ibatis.annotations.Param;

public interface ConfMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Conf record);

    int insertSelective(Conf record);

    Conf selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Conf record);

    int updateByPrimaryKey(Conf record);

    Integer selectMaxCountByTypeAndCampusId(@Param("id") Integer id, @Param("type") int code);

}