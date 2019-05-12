package com.explore.service.Impl;


import com.explore.common.ServerResponse;
import com.explore.dao.StudentMapper;
import com.explore.dao.SubjectMapper;
import com.explore.dao.SubjectStudentMapper;
import com.explore.form.AddSubjectStudent;
import com.explore.pojo.Student;
import com.explore.pojo.Subject;
import com.explore.pojo.SubjectStudent;
import com.explore.service.ISubjectStudentService;
import com.explore.dao.StudentExamMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class SubjectStudentServiceImpl implements ISubjectStudentService {
    @Autowired
    StudentMapper studentMapper;
    @Autowired
    SubjectStudentMapper subjectStudentMapper;
    @Autowired
    StudentExamMapper studentExamMapper;
    @Autowired
    SubjectMapper subjectMapper;


    @Override
    public ServerResponse addSubjectStudent(AddSubjectStudent addSubjectStudent) {
        int count = studentMapper.checkStudent(addSubjectStudent.getPhone(), addSubjectStudent.getIdcard());
        if(count <= 0)
            return ServerResponse.createByErrorMessage("申请失败，请验证您的身份信息！");

        SubjectStudent subjectStudent = new SubjectStudent();
        subjectStudent.setStatus(1);
        subjectStudent.setStartTime(addSubjectStudent.getStartTime());
        subjectStudent.setPosition(addSubjectStudent.getPosition());
        subjectStudentMapper.insert(subjectStudent);
        return ServerResponse.createBySuccessMessage("申请发送成功，正在等待管理员同意申请");
    }

    @Override
    public ServerResponse showSubjectStudent() {
        List<HashMap<String,Object>> allData=new ArrayList<>();
        List<SubjectStudent> subjectStudents = subjectStudentMapper.showSubjectStudent();
        for(int i=0;i<subjectStudents.size();i++){
            Student student = studentMapper.selectByPrimaryKey(subjectStudents.get(i).getStudentId());
            Subject subject = subjectMapper.selectByPrimaryKey(subjectStudents.get(i).getSubjectId());
            HashMap<String,Object> data=new HashMap<>();
            data.put("student",student);
            data.put("subjectStudent",subjectStudents.get(i));
            data.put("subject",subject);
            allData.add(data);
        }
        return ServerResponse.createBySuccess(allData);
    }

    @Override
    public ServerResponse reviewSubjectStudent(SubjectStudent subjectStudent) {
       int count = subjectStudentMapper.updateByPrimaryKey(subjectStudent);
       if(count==1)
           return ServerResponse.createBySuccessMessage("修改成功");
       return ServerResponse.createByErrorMessage("修改失败");
    }

    @Override
    public ServerResponse acceptSubjectStudent(int subjectId, int studentId) {
        return ServerResponse.createBySuccessMessage("success");
    }

    @Override
    public ServerResponse passSubjectStudent(int subjectId, int studentId) {
        return ServerResponse.createBySuccessMessage("success");
    }
}
