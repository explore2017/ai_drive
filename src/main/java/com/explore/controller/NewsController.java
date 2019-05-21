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
    public ServerResponse searchAllNews()
    {
        ServerResponse serverResponse = newsService.searchAllNews();
        return  serverResponse;
    }
    /**
     * 查看所有新闻类型
     * @return
     */
    @GetMapping("/searchNewType")
    public ServerResponse searchNewType()
    {
        ServerResponse serverResponse =newsService.searchNewType();
        return serverResponse;
    }

    /**
     * 不同类型的新闻
     * @return
     */
    @GetMapping("/allType")
    public ServerResponse searchType(Integer typeId)
    {
        ServerResponse serverResponse =newsService.searchType(typeId);
        return serverResponse;
    }

    /**
     * 添加新闻
     * @return
     */
    @PostMapping("/addNews")
    public ServerResponse addNews(@RequestBody News news) {
        ServerResponse serverResponse = newsService.addNews(news);
        return serverResponse;
    }

    /**
     * 修改新闻
     * @return
     */
    @PutMapping("/reviseNews")
    public ServerResponse reviseNews(@RequestBody News news) {
        ServerResponse serverResponse = newsService.reviseNews(news);
        return serverResponse;
    }

    /**
     * 删除资源
     * @return
     */
    @DeleteMapping("/deleteNews/{id}")
    public ServerResponse deleteNews(@PathVariable("id") Integer id) {
        ServerResponse serverResponse =newsService.deleteNews(id);
        return serverResponse;
    }
}
