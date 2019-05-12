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
     * 学生添加
     *  @param campus
     */
    @PostMapping("/insertCampus")
    public ServerResponse addCampus(@RequestBody Campus campus) {
        ServerResponse serverResponse = campusService.addCampus(campus);
        return serverResponse;
    }

    /**
     * 查看该校区所有学员基本信息
     * @param campus
     * @return
     */
    @GetMapping("/searchStudents")
    public ServerResponse searchStudents(Campus campus) {
        ServerResponse serverResponse = campusService.searchStudents(campus);
        return serverResponse;
    }

    /**
     * 查看该校区所有教练基本信息
     * @param campus
     * @return
     */
    @GetMapping("/searchCoaches")
    public ServerResponse searchCoaches(Campus campus) {
        ServerResponse serverResponse = campusService.searchCoaches(campus);
        return serverResponse;
    }

    /**
     * 查看该校区所有车辆基本信息
     * @param campus
     * @return
     */
    @GetMapping("/searchVehicles")
    public ServerResponse searchVehicles(Campus campus) {
        ServerResponse serverResponse = campusService.searchVehicles(campus);
        return serverResponse;
    }

    /**
     * 查看该校区所有学员单次考试信息
     * @param campus
     * @return
     */
    @GetMapping("/searchExam")
    public ServerResponse searchExam(Campus campus) {
        ServerResponse serverResponse = campusService.searchExam(campus);
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
