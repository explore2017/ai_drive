package com.explore.dao;

import com.explore.pojo.StudentExam;

public interface StudentExamMapper {
    int insert(StudentExam record);

    int insertSelective(StudentExam record);

//    List<SubjectStudent> showSubjectStudent();
}