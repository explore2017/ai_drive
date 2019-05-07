package com.explore.controller;

import com.explore.common.ServerResponse;
import com.explore.pojo.News;
import com.explore.service.INewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/news")
public class NewsController {

    @Autowired
    INewsService newsService;

    /**
     * 查看所有新闻
     * @return
     */
    @GetMapping("/searchAllNews")
    public ServerResponse<List<News>> searchAllNews()
    {
        ServerResponse<List<News>> serverResponse = newsService.searchAllNews();
        return  serverResponse;
    }
}
