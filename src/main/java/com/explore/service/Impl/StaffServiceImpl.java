package com.explore.service.Impl;


import com.explore.common.ServerResponse;
import com.explore.dao.CampusMapper;
import com.explore.dao.StaffMapper;
import com.explore.pojo.Staff;
import com.explore.service.IStaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class StaffServiceImpl implements IStaffService {

    @Autowired
    private StaffMapper staffMapper;
    @Autowired
    private CampusMapper campusMapper;

    @Override
    public ServerResponse findAll() {
        List<Map<String,Object>>  ret = new ArrayList<>();
        List<Staff> list =  staffMapper.selectAll();
        for (Staff staff : list) {
            Map<String,Object> map = new HashMap<>();
            map.put("staff",staff);
            map.put("campus",campusMapper.selectByPrimaryKey(staff.getCampusId()));
            ret.add(map);
        }
        return ServerResponse.createBySuccess(ret);
    }

    @Override
    public ServerResponse findById(Integer id) {
        Staff staff = staffMapper.selectByPrimaryKey(id);
        return ServerResponse.createBySuccess(staff);
    }

    @Override
    public ServerResponse deleteById(Integer id) {
        staffMapper.deleteByPrimaryKey(id);
        return ServerResponse.createBySuccessMessage("删除成功");
    }

    @Override
    public ServerResponse save(Staff staff) {
        staff.setCreateTime(new Date());
        staff.setUpdateTime(new Date());
        int count = staffMapper.insert(staff);
        if (count==0){
            return ServerResponse.createByErrorMessage("新增失败");
        }
        return ServerResponse.createBySuccessMessage("新增成功");
    }

    @Override
    public ServerResponse modify(Staff staff) {
        staff.setUpdateTime(new Date());
        staffMapper.updateByPrimaryKeySelective(staff);
        return ServerResponse.createBySuccessMessage("更新成功");
    }
}
