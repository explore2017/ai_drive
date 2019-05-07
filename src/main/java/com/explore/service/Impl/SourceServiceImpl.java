package com.explore.service.Impl;


import com.explore.common.ServerResponse;
import com.explore.dao.SourceMapper;
import com.explore.pojo.Source;
import com.explore.service.ISourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SourceServiceImpl implements ISourceService {
    @Autowired
    SourceMapper sourceMapper;

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
    public ServerResponse<List<Source>> showSources() {
        return ServerResponse.createBySuccess(sourceMapper.showSources());
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
}
