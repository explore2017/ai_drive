package com.explore.dao;

import com.explore.pojo.Quarters;

import java.util.List;

public interface QuartersMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Quarters record);

    int insertSelective(Quarters record);

    Quarters selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Quarters record);

    int updateByPrimaryKey(Quarters record);

    List<Quarters> searchAllQuarters();

    Quarters searchNewQuarter();

    List<Quarters> searchThreeQuarters();
}