package com.explore.service.Impl;

import com.explore.common.ServerResponse;
import com.explore.dao.CampusMapper;
import com.explore.dao.CoachMapper;
import com.explore.dao.StaffMapper;
import com.explore.dao.StudentMapper;
import com.explore.pojo.*;
import com.explore.service.IManageService;
import org.apache.catalina.Manager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Service
public class ManageServiceImpl implements IManageService {

    @Autowired
    StudentMapper studentMapper;
    @Autowired
    CoachMapper coachMapper;
    @Autowired
    StaffMapper staffMapper;
    @Autowired
    CampusMapper campusMapper;

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
        List<HashMap<String,Object>> allData=new ArrayList<>();
        List<Student> students = studentMapper.getAllStudent();
        for(int i=0;i<students.size();i++){
            Campus campus = campusMapper.selectByPrimaryKey(students.get(i).getCampusId());
            Coach coach = coachMapper.selectByPrimaryKey(students.get(i).getCoachId());
            HashMap<String,Object> data=new HashMap<>();
            data.put("student",students.get(i));
            data.put("campus",campus);
            data.put("coach",coach);
            allData.add(data);
        }
        return ServerResponse.createBySuccess(allData);
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
        List<HashMap<String,Object>> allData=new ArrayList<>();
        List<Coach> coaches= coachMapper.getAllCoach();
        for(int i=0;i<coaches.size();i++){
            Campus campus = campusMapper.selectByPrimaryKey(coaches.get(i).getCampusId());
            HashMap<String,Object> data=new HashMap<>();
            data.put("student",coaches.get(i));
            data.put("campus",campus);
            allData.add(data);
        }
        return ServerResponse.createBySuccess(allData);
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
