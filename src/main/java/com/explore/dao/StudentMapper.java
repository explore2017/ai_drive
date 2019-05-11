package com.explore.dao;

import com.explore.pojo.Exam;
import com.explore.pojo.Student;
<<<<<<< HEAD
import org.apache.ibatis.annotations.Param;
=======
import com.explore.pojo.SubjectStudent;

import java.util.List;
>>>>>>> c554e7846a6e71ad97f915f266fb3c769bd3d6c1

public interface StudentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Student record);

    int insertSelective(Student record);

    Student selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);

<<<<<<< HEAD
    int checkStudent(@Param("phone") String phone, @Param("idcard") String idCard);
=======
    List<Student> showStudent(Integer coachId);

    List<SubjectStudent> searchSubjectStudent(Integer coachId);

    List<Student> getAllStudent();

    Student getiIdCard(String idcard);

    Student showMessage(String name, String idcard);

    List<Student> searchStudentCampus(Integer campusId);
>>>>>>> c554e7846a6e71ad97f915f266fb3c769bd3d6c1
}