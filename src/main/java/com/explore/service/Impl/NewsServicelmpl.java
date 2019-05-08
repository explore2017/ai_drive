package com.explore.service.Impl;

import com.explore.common.ServerResponse;
import com.explore.dao.NewsMapper;
import com.explore.pojo.News;
import com.explore.service.INewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.ws.Action;
import java.util.List;

@Service
public class NewsServicelmpl implements INewsService {

    @Autowired
    NewsMapper newsMapper;

    @Override
    public ServerResponse<List<News>> searchAllNews() {
        List<News> news = newsMapper.searchAllNews();
        return ServerResponse.createBySuccess(news);
    }

    @Override
    public ServerResponse addNews(News news) {
        int count = newsMapper.insertSelective(news);
        if(count==1)
            return ServerResponse.createBySuccessMessage("增加新闻成功");
        return ServerResponse.createByErrorMessage("增加新闻失败");
    }

    @Override
    public ServerResponse reviseNews(News news) {
        int count = newsMapper.updateByPrimaryKeySelective(news);
        if(count==1)
            return ServerResponse.createBySuccessMessage("修改新闻成功");
        return ServerResponse.createByErrorMessage("修改新闻失败");
    }

    @Override
    public ServerResponse deleteNews(Integer id) {
        int count = newsMapper.deleteByPrimaryKey((long)id);
        if(count==1)
            return ServerResponse.createBySuccessMessage("删除成功");
        return ServerResponse.createByErrorMessage("删除失败");
    }
}
