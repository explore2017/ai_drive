package com.explore.service;

import com.explore.common.ServerResponse;
import com.explore.pojo.*;

import java.util.List;

public interface ICampusService {

    ServerResponse<List<Student>> searchStudents(Campus campus);

    ServerResponse<List<Coach>> searchCoaches(Campus campus);

    ServerResponse<List<Vehicle>> searchVehicles(Campus campus);

    ServerResponse<List<SubjectStudent>> searchExam(Campus campus);

    ServerResponse deleteCampus(Integer id);
}
