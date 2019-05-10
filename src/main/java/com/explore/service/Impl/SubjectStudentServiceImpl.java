package com.explore.service.Impl;


import com.explore.common.ServerResponse;
import com.explore.dao.StudentMapper;
import com.explore.dao.SubjectStudentMapper;
import com.explore.form.AddSubjectStudent;
import com.explore.pojo.SubjectStudent;
import com.explore.service.IStudentService;
import com.explore.service.ISubjectStudentService;
import com.explore.vo.StudentExamMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectStudentServiceImpl implements ISubjectStudentService {
    @Autowired
    StudentMapper studentMapper;
    @Autowired
    SubjectStudentMapper subjectStudentMapper;
    @Autowired
    StudentExamMapper studentExamMapper;


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
//        List<SubjectStudent> subjectStudents = studentExamMapper.showSubjectStudent();
//        if(subjectStudents == null)
//            return ServerResponse.createByErrorMessage("暂时没有数据");
//        return ServerResponse.createBySuccess(subjectStudents);
        return ServerResponse.createBySuccessMessage("success");
    }

    @Override
    public ServerResponse reviewSubjectStudent(int subjectId, int studentId) {
        return ServerResponse.createBySuccessMessage("success");
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
