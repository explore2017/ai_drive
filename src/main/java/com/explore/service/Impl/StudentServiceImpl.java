package com.explore.service.Impl;


import com.explore.common.ServerResponse;
import com.explore.dao.StudentMapper;
import com.explore.dao.SubjectMapper;
import com.explore.dao.SubjectStudentMapper;
import com.explore.form.PasswordForm;
import com.explore.pojo.Coach;
import com.explore.pojo.Student;
import com.explore.pojo.Subject;
import com.explore.pojo.SubjectStudent;
import com.explore.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class StudentServiceImpl implements IStudentService {

    @Autowired
    StudentMapper studentMapper;
    @Autowired
    SubjectStudentMapper subjectStudentMapper;
    @Autowired
    SubjectMapper subjectMapper;

    @Override
    public ServerResponse showMessage(String name, String idcard) {
        Student student = studentMapper.showMessage(name,idcard);
        if(student==null)
            return ServerResponse.createByErrorMessage("没有此人");
        return ServerResponse.createBySuccessMessage("查找成功",student);
    }

    @Override
    public ServerResponse showExam(Integer studentId) {
        List<HashMap<String,Object>> allData=new ArrayList<>();
        List<SubjectStudent> subjectStudents = subjectStudentMapper.showExamStudent(studentId);
        for (SubjectStudent subjectStudent : subjectStudents) {
            HashMap<String,Object> data=new HashMap<>();
            Subject subject = subjectMapper.selectByPrimaryKey(subjectStudent.getSubjectId());
            data.put("subjectStudent",subjectStudent);
            data.put("subject",subject);
            allData.add(data);
        }
        return ServerResponse.createBySuccess(subjectStudents);
    }

    @Override
    public ServerResponse addCoach(Student student, Coach coach) {
        student.setCoachId(coach.getId());
        student.setCampusId(coach.getCampusId());
        int count = studentMapper.updateByPrimaryKeySelective(student);
        if(count==1){
            return ServerResponse.createBySuccessMessage("归入教练成功");
        }
        return ServerResponse.createByErrorMessage("归入教练失败");
    }

    @Override
    public ServerResponse reviseCampus(Student student, int campus_id) {
        student.setCampusId(campus_id);
        int count = studentMapper.updateByPrimaryKeySelective(student);
        if(count==1)
            return ServerResponse.createBySuccessMessage("改变校区成功");
        return ServerResponse.createByErrorMessage("改变校区失败");
    }

    @Override
    public ServerResponse addSubjectStudent(Student student, SubjectStudent subjectStudent) {
        subjectStudent.setStudentId(student.getId());
        subjectStudent.setStatus(1);
        int count = subjectStudentMapper.updateByPrimaryKey(subjectStudent);
        if(count==1)
            return ServerResponse.createBySuccessMessage("增加成功");
        return ServerResponse.createByErrorMessage("增加失败");
    }

    @Override
    public ServerResponse login(String userName, String password) {
        Student student = studentMapper.login(userName,password);
        if (student==null){
            return ServerResponse.createByErrorMessage("身份证或密码错误");
        }
        return ServerResponse.createBySuccess(student);
    }

    @Override
    public ServerResponse modify(Student modify) {
        if (studentMapper.updateByPrimaryKeySelective(modify)>0){
            return ServerResponse.createBySuccessMessage("修改成功");
        }
        return ServerResponse.createByErrorMessage("修改失败");
    }

    @Override
    public ServerResponse modifyPassword(PasswordForm params, Integer id) {
        Student ad = studentMapper.selectByPrimaryKey(id);
        if (!ad.getPassword().equals(params.getOldPwd())){
            return ServerResponse.createByErrorMessage("旧密码验证失败");
        }
        Student student = new Student();
        student.setId(id);
        student.setPassword(params.getNewPwd());
        int count = studentMapper.updateByPrimaryKeySelective(student);
        if (count > 0){
            return ServerResponse.createBySuccessMessage("修改成功");
        }
        return ServerResponse.createByErrorMessage("修改失败");
    }

    @Override
    public Integer allCount() {
        return studentMapper.selectAllCount();
    }

}
