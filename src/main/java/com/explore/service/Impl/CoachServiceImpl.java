package com.explore.service.Impl;


import com.explore.common.ServerResponse;
import com.explore.dao.CoachMapper;
import com.explore.dao.StudentMapper;
import com.explore.dao.SubjectMapper;
import com.explore.dao.SubjectStudentMapper;
import com.explore.pojo.*;
import com.explore.service.ICoachService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Service
public class CoachServiceImpl implements ICoachService {

    @Autowired
    StudentMapper studentMapper;
    @Autowired
    CoachMapper coachMapper;
    @Autowired
    SubjectStudentMapper subjectStudentMapper;
    @Autowired
    SubjectMapper subjectMapper;

    @Override
    public ServerResponse showStudent(Integer coachId) {
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
    public ServerResponse searchSubjectStudent(Integer coachId) {
        List<HashMap<String,Object>>  allData=new ArrayList<>();
        List<SubjectStudent> subjectStudents = studentMapper.searchSubjectStudent(coachId);
        for(int i =0;i<subjectStudents.size();i++){
            Student student = studentMapper.selectByPrimaryKey(subjectStudents.get(i).getStudentId());
            Subject subject = subjectMapper.selectByPrimaryKey(subjectStudents.get(i).getSubjectId());
            HashMap<String,Object> data=new HashMap<>();
            data.put("name",student.getName());
            data.put("subjectStudent",subjectStudents.get(i));
            data.put("subject",subject);
            allData.add(data);
        }
        return ServerResponse.createBySuccess(allData);
    }

    @Override
    public Integer allCount() {
        return coachMapper.selectAllCount();
    }

    @Override
    public Coach findById(Integer coachId) {
        return coachMapper.selectByPrimaryKey(coachId);
    }
}
