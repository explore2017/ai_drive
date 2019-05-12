package com.explore.service;


import com.explore.common.ServerResponse;
import com.explore.pojo.Coach;
import com.explore.pojo.Student;
import com.explore.pojo.SubjectStudent;

import java.util.List;

public interface IStudentService {

    ServerResponse showMessage(String name, String idcard);

    ServerResponse showExam(Integer studentId);

    ServerResponse addCoach(Student student, Coach coach);

    ServerResponse reviseCampus(Student student, int campus_id);

    ServerResponse addSubjectStudent(Student student, SubjectStudent subjectStudent);

    ServerResponse login(String idcard, String password);
}
