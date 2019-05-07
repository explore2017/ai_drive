package com.explore.service;

import com.explore.common.ServerResponse;
import com.explore.pojo.Coach;
import com.explore.pojo.Student;
import org.apache.catalina.Manager;

import java.util.List;

public interface IManageService {

    ServerResponse<Manager> login(String username, String password);

    ServerResponse revise(String username, String oldPassword, String newPassword);

    ServerResponse<List<Student>> Students();

    ServerResponse addStudent(Student student);

    ServerResponse outStudent(Integer id);

    ServerResponse reviseStudent(Student student);

    ServerResponse<List<Coach>> Coachs();

    ServerResponse addCoach(Coach teacher, String[] subjectId);

    ServerResponse outCoach(Integer id);

    ServerResponse reviseCoach(Coach teacher, String[] subjectId);
}
