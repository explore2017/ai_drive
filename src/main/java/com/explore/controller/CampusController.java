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
     * 校区添加
     *  @param campus
     */
    @PostMapping("/insertCampus")
    public ServerResponse addCampus(@RequestBody Campus campus) {
        return campusService.addCampus(campus);
    }

    /**
     * 修改校区信息
     */
    @PutMapping("/reviseCampus")
    public ServerResponse reviseCampus(@RequestBody Campus campus) {
        return campusService.reviseCampus(campus);
    }

    /**
     * 查看该校区所有学员基本信息
     * @param campus
     * @return
     */
    @GetMapping("/searchStudents")
    public ServerResponse searchStudents(@RequestBody Campus campus) {
        return campusService.searchStudents(campus);
    }

    /**
     * 查看该校区所有教练基本信息
     * @param campus
     * @return
     */
    @GetMapping("/searchCoaches")
    public ServerResponse searchCoaches(@RequestBody Campus campus) {
        return campusService.searchCoaches(campus);
    }

    /**
     * 查看该校区所有车辆基本信息
     * @param campus
     * @return
     */
    @GetMapping("/searchVehicles")
    public ServerResponse searchVehicles(@RequestBody Campus campus) {
        return campusService.searchVehicles(campus);
    }

    /**
     * 查看该校区所有学员单次考试信息
     * @param campus
     * @return
     */
    @GetMapping("/searchExam")
    public ServerResponse searchExam(@RequestBody Campus campus) {
        return campusService.searchExam(campus);
    }

    /**
     * 删除校区
     * @return
     */
    @DeleteMapping("/deleteCampus/{id}")
    public ServerResponse deleteCampus(@PathVariable("id") Integer id) {
        return campusService.deleteCampus(id);
    }
}
