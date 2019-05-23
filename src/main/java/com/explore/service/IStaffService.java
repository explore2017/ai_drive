package com.explore.service;

import com.explore.common.ServerResponse;
import com.explore.pojo.Staff;

public interface IStaffService {

    ServerResponse findAll();

    ServerResponse findById(Integer id);

    ServerResponse deleteById(Integer id);

    ServerResponse save(Staff staff);

    ServerResponse modify(Staff staff);
}
