package com.explore.service.Impl;

import com.explore.common.ServerResponse;
import com.explore.dao.CoachMapper;
import com.explore.dao.StaffMapper;
import com.explore.dao.StudentMapper;
import com.explore.pojo.Coach;
import com.explore.pojo.Manage;
import com.explore.pojo.Staff;
import com.explore.pojo.Student;
import com.explore.service.IManageService;
import org.apache.catalina.Manager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ManageServiceImpl implements IManageService {

    @Autowired
    StudentMapper studentMapper;
    @Autowired
    CoachMapper coachMapper;
    @Autowired
    StaffMapper staffMapper;

    @Override
    public ServerResponse<Staff> login(String name, String password) {
        Staff staff = staffMapper.login(name,password);
        if(staff==null){
            return ServerResponse.createByErrorMessage("用户名或密码错误");
        }
        return ServerResponse.createBySuccessMessage("登陆成功",staff);
    }

    @Override
    public ServerResponse revise(String name, String oldPassword, String newPassword) {
        Staff staff = staffMapper.login(name,oldPassword);
        if(staff==null)
            return ServerResponse.createByErrorMessage("密码输入错误");
        staff.setPassword(newPassword);
        int count = staffMapper.updateByPrimaryKeySelective(staff);
        if(count==1)
            return ServerResponse.createBySuccessMessage("修改成功");
        return ServerResponse.createByErrorMessage("修改失败");
    }

    @Override
    public ServerResponse Students() {
        return ServerResponse.createBySuccess(studentMapper.getAllStudent());
    }

    @Override
    public ServerResponse addStudent(Student student) {
        Student student1 = studentMapper.getiIdCard(student.getIdcard());
        if(student1==null)
        {
            int count = studentMapper.insert(student);
            if(count==1)
            {
                return ServerResponse.createBySuccessMessage("学生增加成功");
            }
            return ServerResponse.createByErrorMessage("学生增加失败");
        }
        return ServerResponse.createByErrorMessage("学生相同");

    }

    @Override
    public ServerResponse outStudent(Integer id) {
        int count = studentMapper.deleteByPrimaryKey(id);
        if(count==1)
            return ServerResponse.createBySuccessMessage("学生删除成功");
        return ServerResponse.createByErrorMessage("学生删除失败");
    }

    @Override
    public ServerResponse reviseStudent(Student student) {
        int count = studentMapper.updateByPrimaryKeySelective(student);
        if(count==1)
            return ServerResponse.createBySuccessMessage("学生修改成功");
        return ServerResponse.createByErrorMessage("学生修改失败");
    }

    @Override
    public ServerResponse Coachs() {
        return ServerResponse.createBySuccess(coachMapper.getAllCoach());
    }

    @Override
    public ServerResponse addCoach(Coach coach) {
        Date creat_time = new Date();
        coach.setCreateTime(creat_time);
        coach.setUpdateTime(creat_time);
        int count = coachMapper.insert(coach);
        if(count==1)
            return ServerResponse.createBySuccessMessage("教练增加成功");
        return ServerResponse.createByErrorMessage("教练增加失败");
    }

    @Override
    public ServerResponse outCoach(Integer id) {
        int count=coachMapper.deleteByPrimaryKey(id);
        if(count==1)
            return ServerResponse.createBySuccessMessage("教练删除成功");
        return  ServerResponse.createByErrorMessage("教练删除失败");
    }

    @Override
    public ServerResponse reviseCoach(Coach coach) {
        Date update_time = new Date();
        coach.setUpdateTime(update_time);
        int count = coachMapper.updateByPrimaryKeySelective(coach);
        if(count==1)
            return ServerResponse.createBySuccessMessage("教练修改成功");
        return ServerResponse.createByErrorMessage("教练修改失败");
    }
}
