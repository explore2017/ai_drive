package com.explore.controller;


import com.explore.common.ServerResponse;
import com.explore.pojo.*;
import com.explore.service.ICampusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/campus")
public class CampusController {

    @Autowired
    ICampusService campusService;


    /**
     * 查看该校区所有学员基本信息
     * @param campus
     * @return
     */
    @GetMapping("/searchStudents")
    public ServerResponse<List<Student>> searchStudents(Campus campus) {
        ServerResponse<List<Student>> serverResponse = campusService.searchStudents(campus);
        return serverResponse;
    }

    /**
     * 查看该校区所有教练基本信息
     * @param campus
     * @return
     */
    @GetMapping("/searchCoaches")
    public ServerResponse<List<Coach>> searchCoaches(Campus campus) {
        ServerResponse<List<Coach>> serverResponse = campusService.searchCoaches(campus);
        return serverResponse;
    }

    /**
     * 查看该校区所有车辆基本信息
     * @param campus
     * @return
     */
    @GetMapping("/searchVehicles")
    public ServerResponse<List<Vehicle>> searchVehicles(Campus campus) {
        ServerResponse<List<Vehicle>> serverResponse = campusService.searchVehicles(campus);
        return serverResponse;
    }

    /**
     * 查看该校区所有学员单次考试信息
     * @param campus
     * @return
     */
    @GetMapping("/searchExam")
    public ServerResponse<List<SubjectStudent>> searchExam(Campus campus) {
        ServerResponse<List<SubjectStudent>> serverResponse = campusService.searchExam(campus);
        return ServerResponse.createBySuccessMessage("success");
    }

    /**
     * 删除校区
     * @return
     */
    @DeleteMapping("/deleteCampus/{id}")
    public ServerResponse deleteCampus(@PathVariable("id") Integer id) {
        ServerResponse serverResponse = campusService.deleteCampus(id);
        return serverResponse;
    }
}
