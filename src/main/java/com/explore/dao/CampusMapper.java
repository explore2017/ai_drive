package com.explore.dao;

import com.explore.pojo.Campus;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CampusMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Campus record);

    int insertSelective(Campus record);

    Campus selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Campus record);

    int updateByPrimaryKey(Campus record);

    List<Campus> getAllCampus();

    Integer selectAllCount();

}