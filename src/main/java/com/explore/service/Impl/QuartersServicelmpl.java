package com.explore.service.Impl;

import com.explore.common.ServerResponse;
import com.explore.pojo.Quarters;
import com.explore.service.IQuartersService;
import com.explore.vo.QuartersMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class QuartersServicelmpl implements IQuartersService {

    @Autowired
    QuartersMapper quartersMapper;

    @Override
    public ServerResponse searchAllQuarters() {
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH )+1;
        Quarters quarter = quartersMapper.searchNewQuarter();
        if(quarter.getYears()!=String.valueOf(year) ||quarter.getQuarters()!=String.valueOf(month))
        {
            Quarters quarter1 = new Quarters();
            quarter1.setYears(String.valueOf(year));
            quarter1.setQuarters(String.valueOf(month));
        }
        List<Quarters> quarters = quartersMapper.searchAllQuarters();
        return ServerResponse.createBySuccess(quarters);
    }
}
