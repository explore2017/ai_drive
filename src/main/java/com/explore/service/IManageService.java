package com.explore.service;

import com.explore.common.ServerResponse;
import com.explore.pojo.Coach;
import com.explore.pojo.Staff;
import com.explore.pojo.Student;
import org.apache.catalina.Manager;

import java.util.List;

public interface IManageService {

    ServerResponse<Staff> login(String username, String password);

    ServerResponse revise(String username, String oldPassword, String newPassword);

    ServerResponse Students();

    ServerResponse addStudent(Student student);

    ServerResponse outStudent(Integer id);

    ServerResponse reviseStudent(Student student);

    ServerResponse Coachs();

    ServerResponse addCoach(Coach coach);

    ServerResponse outCoach(Integer id);

    ServerResponse reviseCoach(Coach coach);
}
