package com.explore.dao;

import com.explore.pojo.SubjectStudent;
import org.apache.ibatis.annotations.Param;

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

    List<SubjectStudent> selectByStudentId(Integer id);

    Integer cancel(@Param("studentId") Integer studentId,@Param("id") Integer sbId);

}