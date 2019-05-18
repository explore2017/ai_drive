package com.explore.dao;

import com.explore.pojo.StudentExam;
import com.explore.pojo.SubjectStudent;

import java.util.List;

public interface StudentExamMapper {
    int insert(StudentExam record);

    int insertSelective(StudentExam record);

    List<SubjectStudent> showSubjectStudent();

    List<SubjectStudent> findStudentExam(String name);
}