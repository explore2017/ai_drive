package com.explore.service.Impl;


import com.explore.common.ServerResponse;
import com.explore.dao.CoachMapper;
import com.explore.dao.StudentMapper;
import com.explore.dao.SubjectStudentMapper;
import com.explore.pojo.Coach;
import com.explore.pojo.Exam;
import com.explore.pojo.Student;
import com.explore.pojo.SubjectStudent;
import com.explore.service.ICoachService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CoachServiceImpl implements ICoachService {

    @Autowired
    StudentMapper studentMapper;
    @Autowired
    CoachMapper coachMapper;
    @Autowired
    SubjectStudentMapper subjectStudentMapper;

    @Override
    public ServerResponse<List<Student>> showStudent(Integer coachId) {
        List<Student> students = studentMapper.showStudent(coachId);
        return ServerResponse.createBySuccess(students);
    }

    @Override
    public ServerResponse reviseCampus(Coach coach) {
        Date update_time = new Date();
        coach.setUpdateTime(update_time);
        int count = coachMapper.updateByPrimaryKeySelective(coach);
        if(count == 1)
            return ServerResponse.createBySuccessMessage("修改成功");
        return ServerResponse.createByErrorMessage("修改失败");
    }

    @Override
    public ServerResponse<List<SubjectStudent>> searchSubjectStudent(Integer coachId) {
        List<SubjectStudent> subjectStudents = studentMapper.searchSubjectStudent(coachId);
        return ServerResponse.createBySuccess(subjectStudents);
    }
}
