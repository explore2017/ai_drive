package com.explore.service.Impl;

import com.explore.common.ServerResponse;
import com.explore.dao.*;
import com.explore.pojo.*;
import com.explore.service.ICampusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class CampusServiceImpl implements ICampusService {

    @Autowired
    StudentMapper studentMapper;
    @Autowired
    CoachMapper coachMapper;
    @Autowired
    VehicleMapper vehicleMapper;
    @Autowired
    SubjectStudentMapper subjectStudentMapper;
    @Autowired
    CampusMapper campusMapper;
    @Autowired
    SubjectMapper subjectMapper;

    @Override
    public ServerResponse searchStudents(Campus campus) {
        List<Student> students = studentMapper.searchStudentCampus(campus.getId());
        return ServerResponse.createBySuccess(students);
    }

    @Override
    public ServerResponse searchCoaches(Campus campus) {
        List<Coach> coaches = coachMapper.searchCoachesCampus(campus.getId());
        return ServerResponse.createBySuccess(coaches);
    }

    @Override
    public ServerResponse searchVehicles(Campus campus) {
        List<Vehicle> vehicles = vehicleMapper.searchVehiclesCampus(campus.getId());
        return ServerResponse.createBySuccess(vehicles);
    }

    @Override
    public ServerResponse searchExam(Campus campus) {
        List<HashMap<String,Object>>  allData=new ArrayList<>();
        List<SubjectStudent> subjectStudents = subjectStudentMapper.searchExam(campus.getId());
        for(int i =0;i<subjectStudents.size();i++){
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
    public ServerResponse deleteCampus(Integer id) {
        int count = campusMapper.deleteByPrimaryKey(id);
        if(count==1)
            return ServerResponse.createBySuccessMessage("删除成功");
        return ServerResponse.createByErrorMessage("删除失败");
    }

    @Override
    public ServerResponse addCampus(Campus campus) {
        int count = campusMapper.insertSelective(campus);
        if(count ==1)
            return ServerResponse.createBySuccessMessage("增加成功");
        return ServerResponse.createByErrorMessage("增加失败");
    }
}
