package com.explore.service;

import com.explore.common.ServerResponse;
import com.explore.pojo.*;

import java.util.List;

public interface ICampusService {

    ServerResponse searchStudents(Campus campus);

    ServerResponse searchCoaches(Campus campus);

    ServerResponse searchVehicles(Campus campus);

    ServerResponse searchExam(Campus campus);

    ServerResponse deleteCampus(Integer id);

    ServerResponse addCampus(Campus campus);

    ServerResponse reviseCampus(Campus campus);

    Integer allCount();

    Campus findById(Integer campusId);
}
