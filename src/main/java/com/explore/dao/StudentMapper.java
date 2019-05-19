package com.explore.dao;
import com.explore.pojo.Student;
import org.apache.ibatis.annotations.Param;
import com.explore.pojo.SubjectStudent;

import java.util.List;

public interface StudentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Student record);

    int insertSelective(Student record);

    Student selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);

    int checkStudent(@Param("phone") String phone, @Param("idcard") String idCard);
    List<Student> showStudent(Integer coachId);

    List<SubjectStudent> searchSubjectStudent(Integer coachId);

    List<Student> getAllStudent();

    Student getiIdCard(String idcard);

    Student showMessage(String name, String idcard);

    List<Student> searchStudentCampus(Integer campusId);

    Student login(@Param("idcard") String userName,@Param("password") String password);

    List<Student> showStudents(Student student);
}