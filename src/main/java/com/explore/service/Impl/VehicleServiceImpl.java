package com.explore.service.Impl;


import com.explore.common.ServerResponse;
import com.explore.dao.VehicleMapper;
import com.explore.pojo.Vehicle;
import com.explore.service.IVehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleServiceImpl implements IVehicleService {

    @Autowired
    VehicleMapper vehicleMapper;

    @Override
    public ServerResponse addVehicle(Vehicle vehicle) {
        int count = vehicleMapper.insertSelective(vehicle);
        if(count==1)
            return ServerResponse.createBySuccessMessage("增加成功");
        return ServerResponse.createByErrorMessage("增加失败");
    }

    @Override
    public ServerResponse<List<Vehicle>> showVehicles() {
        List<Vehicle> vehicles = vehicleMapper.showVehicles();
        return ServerResponse.createBySuccess(vehicles);
    }

    @Override
    public ServerResponse reviseVehicle(Vehicle vehicle) {
        int count = vehicleMapper.updateByPrimaryKeySelective(vehicle);
        if(count==1)
            return ServerResponse.createBySuccessMessage("修改车辆信息成功");
        return ServerResponse.createByErrorMessage("修改车辆信息失败");
    }

    @Override
    public ServerResponse deleteVehicle(Integer id) {
        int count = vehicleMapper.deleteByPrimaryKey(id);
        if(count==1)
            return ServerResponse.createBySuccessMessage("删除车辆成功");
        return ServerResponse.createByErrorMessage("删除车辆失败");
    }
}
