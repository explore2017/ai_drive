package com.explore.service.Impl;

import com.explore.common.ServerResponse;
import com.explore.dao.NewsMapper;
import com.explore.dao.NewsTypeMapper;
import com.explore.pojo.News;
import com.explore.pojo.NewsType;
import com.explore.service.INewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.ws.Action;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Service
public class NewsServicelmpl implements INewsService {

    @Autowired
    NewsMapper newsMapper;
    @Autowired
    NewsTypeMapper newsTypeMapper;

    @Override
    public ServerResponse searchAllNews() {
        List<HashMap<String,Object>>  allData=new ArrayList<>();
        List<News> news = newsMapper.searchAllNews();
        for(int i=0;i<news.size();i++){
            NewsType newsType = newsTypeMapper.selectByPrimaryKey((long)news.get(i).getTypeId());
            HashMap<String,Object> data=new HashMap<>();
            data.put("news",news.get(i));
            data.put("newsType",newsType);
            allData.add(data);
        }
        return ServerResponse.createBySuccess(allData);
    }

    @Override
    public ServerResponse addNews(News news) {
        Date creat_time = new Date();
        news.setCreateTime(creat_time);
        int count = newsMapper.insertSelective(news);
        if(count==1)
            return ServerResponse.createBySuccessMessage("增加新闻成功");
        return ServerResponse.createByErrorMessage("增加新闻失败");
    }

    @Override
    public ServerResponse reviseNews(News news) {
        Date update_time = new Date();
        news.setUpdateTime(update_time);
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

    @Override
    public ServerResponse searchNewType() {
        List<NewsType> newsTypes = newsTypeMapper.searchNewType();
        return ServerResponse.createBySuccess(newsTypes);
    }
}
