package com.explore.dao;

import com.explore.pojo.SubjectStudent;

import java.util.List;

public interface SubjectStudentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SubjectStudent record);

    int insertSelective(SubjectStudent record);

    SubjectStudent selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SubjectStudent record);

    int updateByPrimaryKey(SubjectStudent record);

    List<SubjectStudent> showExamStudent(Integer studentId);

    List<SubjectStudent> searchExam(Integer campusId);

    List<SubjectStudent> showSubjectStudent();

    SubjectStudent SubjectStudent(int subjectId, int studentId);
}