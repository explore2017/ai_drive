package com.explore.dao;

import com.explore.pojo.Source;

import java.util.List;

public interface SourceMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Source record);

    int insertSelective(Source record);

    Source selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Source record);

    int updateByPrimaryKey(Source record);

    List<Source> showSources();
}