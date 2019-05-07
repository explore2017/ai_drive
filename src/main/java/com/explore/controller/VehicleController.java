package com.explore.controller;

import com.explore.common.ServerResponse;
import com.explore.pojo.Vehicle;
import com.explore.service.IVehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/vehicle")
public class VehicleController {

    @Autowired
    IVehicleService VehicleService;


    /**
     * 添加车辆
     * @param vehicle
     * @return
     */
    @PostMapping("/addVehicle")
    public ServerResponse addVehicle(@RequestBody Vehicle vehicle) {

        return ServerResponse.createBySuccessMessage("success");
    }

    /**
     * 展示所有车辆
     * @return
     */
    @PostMapping("/showVehicles")
    public ServerResponse showVehicles() {

        return ServerResponse.createBySuccessMessage("success");
    }

    /**
     * 展示单个车辆
     * @param vehicle
     * @return
     */
    @PostMapping("/showVehicle")
    public ServerResponse showVehicle(@RequestBody Vehicle vehicle) {

        return ServerResponse.createBySuccessMessage("success");
    }

    /**
     * 修改车辆
     * @param vehicle
     * @param id
     * @return
     */
    @PostMapping("/reviseVehicle")
    public ServerResponse reviseVehicle(@RequestBody Vehicle vehicle, int id) {

        return ServerResponse.createBySuccessMessage("success");
    }

    /**
     * 删除车辆
     * @param vehicle
     * @return
     */
    @PostMapping("/deleteVehicle")
    public ServerResponse deleteVehicle(@RequestBody Vehicle vehicle) {

        return ServerResponse.createBySuccessMessage("success");
    }
}
