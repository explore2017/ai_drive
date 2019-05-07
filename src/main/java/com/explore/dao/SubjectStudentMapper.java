package com.explore.dao;

import com.explore.pojo.SubjectStudent;

public interface SubjectStudentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SubjectStudent record);

    int insertSelective(SubjectStudent record);

    SubjectStudent selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SubjectStudent record);

    int updateByPrimaryKey(SubjectStudent record);
}