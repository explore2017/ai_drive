package com.explore.service.Impl;


import com.explore.common.ServerResponse;
import com.explore.dao.StudentMapper;
import com.explore.dao.SubjectMapper;
import com.explore.dao.SubjectStudentMapper;
import com.explore.form.AddSubjectStudent;
import com.explore.pojo.Student;
import com.explore.pojo.StudentExam;
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
        if(count <= 0){
            return ServerResponse.createByErrorMessage("申请失败，请验证您的身份信息！");
        }
        SubjectStudent subjectStudent = new SubjectStudent();
        subjectStudent.setStatus(1);
        subjectStudent.setStartTime(addSubjectStudent.getStartTime());
        subjectStudent.setPosition(addSubjectStudent.getPosition());
        subjectStudentMapper.insert(subjectStudent);
        return ServerResponse.createBySuccessMessage("申请发送成功，正在等待管理员同意申请");
    }

    @Override
    public ServerResponse showSubjectStudent() {
        List<SubjectStudent> subjectStudents = studentExamMapper.showSubjectStudent();
        if(subjectStudents.size() != 0)
            return ServerResponse.createBySuccess(subjectStudents);
        return  ServerResponse.createByErrorMessage("暂时没有数据");
    }

    @Override
    public ServerResponse reviewSubjectStudent(SubjectStudent subjectStudent) {
        int count = subjectStudentMapper.updateByPrimaryKeySelective(subjectStudent);
        if(count==1)
            return ServerResponse.createBySuccessMessage("修改成功");
        return ServerResponse.createByErrorMessage("修改失败");
    }

    @Override
    public ServerResponse deleteSubjectStudent( int id) {
        int count = subjectStudentMapper.deleteByPrimaryKey(id);
        if(count==1)
            return ServerResponse.createBySuccessMessage("删除成功");
        return ServerResponse.createByErrorMessage("删除失败");
    }

    @Override
    public ServerResponse showStudentExam(StudentExam studentExam) {
        List<SubjectStudent> subjectStudents =  studentExamMapper.findStudentExam(studentExam);

        if(subjectStudents.size() != 0)
            return ServerResponse.createBySuccess(subjectStudents);
        return  ServerResponse.createByErrorMessage("暂时没有数据");
    }

    @Override
    public ServerResponse acceptSubjectStudent(SubjectStudent subjectStudent) {
        int count = subjectStudentMapper.updateByPrimaryKey(subjectStudent);
        if(count==1)
            return ServerResponse.createBySuccessMessage("确认成功");
        return ServerResponse.createByErrorMessage("确认失败");
    }

    @Override
    public ServerResponse passSubjectStudent(SubjectStudent subjectStudent) {
        int count = subjectStudentMapper.updateByPrimaryKey(subjectStudent);
        if(count==1)
            return ServerResponse.createBySuccessMessage("通过成功");
        return ServerResponse.createByErrorMessage("通过失败");
    }
}
