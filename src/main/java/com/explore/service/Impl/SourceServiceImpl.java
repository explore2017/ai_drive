package com.explore.service.Impl;


import com.explore.common.ServerResponse;
import com.explore.dao.CampusMapper;
import com.explore.dao.SourceMapper;
import com.explore.pojo.Campus;
import com.explore.pojo.Source;
import com.explore.service.ISourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class SourceServiceImpl implements ISourceService {
    @Autowired
    SourceMapper sourceMapper;
    @Autowired
    CampusMapper campusMapper;

    @Override
    public ServerResponse addSource(Source source) {
        int count = sourceMapper.insertSelective(source);
        if(count==1)
        {
            return ServerResponse.createBySuccessMessage("增加资源成功");
        }
        return ServerResponse.createByErrorMessage("增加资源失败");
    }

    @Override
    public ServerResponse showSources() {
        List<HashMap<String,Object>> allData=new ArrayList<>();
        List<Source> sources = sourceMapper.showSources();
        for(int i=0;i<sources.size();i++) {
            Campus campus = campusMapper.selectByPrimaryKey(sources.get(i).getCampusId());
            HashMap<String,Object> data=new HashMap<>();
            data.put("source",sources.get(i));
            data.put("campus",campus);
            allData.add(data);
        }
        return ServerResponse.createBySuccess(allData);
    }

    @Override
    public ServerResponse reviseSource(Source source) {
        int count = sourceMapper.updateByPrimaryKeySelective(source);
        if(count==1)
        {
            return ServerResponse.createBySuccessMessage("修改资源成功");
        }
        return ServerResponse.createByErrorMessage("修改资源失败");
    }

    @Override
    public ServerResponse deleteSource(Integer id) {
        int count = sourceMapper.deleteByPrimaryKey(id);
        if(count==1)
        {
            return ServerResponse.createBySuccessMessage("删除资源成功");
        }
        return ServerResponse.createByErrorMessage("删除资源失败");
    }

    @Override
    public ServerResponse showSource(Source source) {
        List<HashMap<String,Object>> allData=new ArrayList<>();
        List<Source> sources = sourceMapper.showSource(source);
        for(int i=0;i<sources.size();i++) {
            Campus campus = campusMapper.selectByPrimaryKey(sources.get(i).getCampusId());
            HashMap<String,Object> data=new HashMap<>();
            data.put("source",sources.get(i));
            data.put("campus",campus);
            allData.add(data);
        }
        return ServerResponse.createBySuccess(allData);
    }
}
