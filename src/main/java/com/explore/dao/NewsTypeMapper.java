package com.explore.dao;

import com.explore.pojo.NewsType;

public interface NewsTypeMapper {
    int deleteByPrimaryKey(Long id);

    int insert(NewsType record);

    int insertSelective(NewsType record);

    NewsType selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(NewsType record);

    int updateByPrimaryKey(NewsType record);
}