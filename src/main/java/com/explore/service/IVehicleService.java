package com.explore.service;

import com.explore.common.ServerResponse;
import com.explore.pojo.Vehicle;

import java.util.List;

public interface IVehicleService {

    ServerResponse addVehicle(Vehicle vehicle);

    ServerResponse<List<Vehicle>> showVehicles();

    ServerResponse reviseVehicle(Vehicle vehicle);

    ServerResponse deleteVehicle(Integer id);
}
