package com.explore.dao;

import com.explore.pojo.Coach;

import java.util.List;

public interface CoachMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Coach record);

    int insertSelective(Coach record);

    Coach selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Coach record);

    int updateByPrimaryKey(Coach record);

    List<Coach> getAllCoach();

    List<Coach> searchCoachesCampus(Integer campusId);

    Integer selectAllCount();

    Integer  selectAllCountByCampusId(Integer id);
}