package com.explore.service.Impl;


import com.explore.common.ServerResponse;
import com.explore.dao.CampusMapper;
import com.explore.dao.CoachMapper;
import com.explore.dao.StaffMapper;
import com.explore.dao.VehicleMapper;
import com.explore.pojo.Campus;
import com.explore.pojo.Coach;
import com.explore.pojo.Vehicle;
import com.explore.service.IVehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class VehicleServiceImpl implements IVehicleService {

    @Autowired
    VehicleMapper vehicleMapper;
    @Autowired
    CoachMapper coachMapper;
    @Autowired
    CampusMapper campusMapper;

    @Override
    public ServerResponse addVehicle(Vehicle vehicle) {
        int count = vehicleMapper.insertSelective(vehicle);
        if(count==1)
            return ServerResponse.createBySuccessMessage("增加成功");
        return ServerResponse.createByErrorMessage("增加失败");
    }

    @Override
    public ServerResponse showVehicles() {
        List<HashMap<String,Object>> allData=new ArrayList<>();
        List<Vehicle> vehicles = vehicleMapper.showVehicles();
        for(int i=0;i<vehicles.size();i++){
            Campus campus = campusMapper.selectByPrimaryKey(vehicles.get(i).getCompusId());
            Coach coach = coachMapper.selectByPrimaryKey(vehicles.get(i).getCoachId());
            HashMap<String,Object> data=new HashMap<>();
            data.put("vehicle",vehicles.get(i));
            if(campus!=null){
                data.put("campusName",campus.getName());
            }else{
                data.put("campusName","");
            }
            if(coach!=null){
                data.put("coachName",coach.getName());
            }else{
                data.put("coachName","");
            }
            allData.add(data);
        }
        return ServerResponse.createBySuccess(allData);
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
