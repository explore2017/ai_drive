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
}
