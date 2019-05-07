package com.explore.service.Impl;

import com.explore.common.ServerResponse;
import com.explore.dao.*;
import com.explore.pojo.*;
import com.explore.service.ICampusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    @Override
    public ServerResponse<List<Student>> searchStudents(Campus campus) {
        List<Student> students = studentMapper.searchStudentCampus(campus.getId());
        return ServerResponse.createBySuccess(students);
    }

    @Override
    public ServerResponse<List<Coach>> searchCoaches(Campus campus) {
        List<Coach> coaches = coachMapper.searchCoachesCampus(campus.getId());
        return ServerResponse.createBySuccess(coaches);
    }

    @Override
    public ServerResponse<List<Vehicle>> searchVehicles(Campus campus) {
        List<Vehicle> vehicles = vehicleMapper.searchVehiclesCampus(campus.getId());
        return ServerResponse.createBySuccess(vehicles);
    }

    @Override
    public ServerResponse<List<SubjectStudent>> searchExam(Campus campus) {
        List<SubjectStudent> subjectStudents = subjectStudentMapper.searchExam(campus.getId());
        return ServerResponse.createBySuccess(subjectStudents);
    }

    @Override
    public ServerResponse deleteCampus(Integer id) {
        int count = campusMapper.deleteByPrimaryKey(id);
        if(count==1)
            return ServerResponse.createBySuccessMessage("删除成功");
        return ServerResponse.createByErrorMessage("删除失败");
    }
}
