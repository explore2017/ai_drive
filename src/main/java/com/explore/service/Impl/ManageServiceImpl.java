package com.explore.service.Impl;

import com.explore.common.ServerResponse;
import com.explore.pojo.Coach;
import com.explore.pojo.Student;
import com.explore.service.IManageService;
import org.apache.catalina.Manager;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManageServiceImpl implements IManageService {
    @Override
    public ServerResponse<Manager> login(String username, String password) {
        return null;
    }

    @Override
    public ServerResponse revise(String username, String oldPassword, String newPassword) {
        return null;
    }

    @Override
    public ServerResponse<List<Student>> Students() {
        return null;
    }

    @Override
    public ServerResponse addStudent(Student student) {
        return null;
    }

    @Override
    public ServerResponse outStudent(Integer id) {
        return null;
    }

    @Override
    public ServerResponse reviseStudent(Student student) {
        return null;
    }

    @Override
    public ServerResponse<List<Coach>> Coachs() {
        return null;
    }

    @Override
    public ServerResponse addCoach(Coach teacher, String[] subjectId) {
        return null;
    }

    @Override
    public ServerResponse outCoach(Integer id) {
        return null;
    }

    @Override
    public ServerResponse reviseCoach(Coach teacher, String[] subjectId) {
        return null;
    }
}
