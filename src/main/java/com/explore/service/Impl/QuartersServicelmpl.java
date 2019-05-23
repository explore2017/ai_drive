package com.explore.service.Impl;

import com.explore.common.ServerResponse;
import com.explore.dao.StudentMapper;
import com.explore.pojo.Quarters;
import com.explore.service.IQuartersService;
import com.explore.dao.QuartersMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.HashMap;
@Service
public class QuartersServicelmpl implements IQuartersService {

    @Autowired
    QuartersMapper quartersMapper;
    @Autowired
    StudentMapper studentMapper;

    @Override
    public ServerResponse searchAllQuarters() {
        List<HashMap<String,Object>> allData=new ArrayList<>();
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH )+1;
        Quarters quarter = quartersMapper.searchNewQuarter();
        if(quarter.getYears()!=String.valueOf(year) ||quarter.getQuarters()!=String.valueOf(month/3+1))
        {
            Quarters quarter1 = new Quarters();
            quarter1.setYears(String.valueOf(year));
            quarter1.setQuarters(String.valueOf(month/3+1));
            quarter1.setPlanNumber(50);
            quarter1.setDescribe(year+"年第"+(month/3+1)+"季度");
            quarter1.setStatus(0);
            quartersMapper.insertSelective(quarter1);
        }
        List<Quarters> quarters = quartersMapper.searchAllQuarters();
        for (Quarters quarter2 : quarters) {
           int nowNumber = studentMapper.getQuarterStudent(quarter2.getId()).size();
            HashMap<String,Object> data=new HashMap<>();
            data.put("quarter",quarter2);
            data.put("nowNumber",nowNumber);
            allData.add(data);
        }
        return ServerResponse.createBySuccess(quarters);
    }

    @Override
    public ServerResponse searchThreeQuarters() {
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH) + 1;
        Quarters quarter = quartersMapper.searchNewQuarter();
        if (quarter.getYears() != String.valueOf(year) || quarter.getQuarters() != String.valueOf(month / 3 + 1)) {
            Quarters quarter1 = new Quarters();
            quarter1.setYears(String.valueOf(year));
            quarter1.setQuarters(String.valueOf(month / 3 + 1));
            quarter1.setPlanNumber(50);
            quarter1.setDescribe(year + "年第" + (month / 3 + 1) + "季度");
            quarter1.setStatus(0);
            quartersMapper.insertSelective(quarter1);
        }
        List<Quarters> quarters = quartersMapper.searchThreeQuarters();
        return ServerResponse.createBySuccess(quarters);
    }

    @Override
    public ServerResponse reviseQuarters(Quarters quarters) {
        int count = quartersMapper.updateByPrimaryKeySelective(quarters);
        if(count==1)
        {
            return ServerResponse.createBySuccessMessage("修改成功");
        }
        return ServerResponse.createByErrorMessage("修改失败");
    }
}
