package com.explore.service;

import com.explore.common.ServerResponse;
import com.explore.pojo.News;

import java.util.List;

public interface INewsService {
    ServerResponse searchAllNews();

    ServerResponse addNews(News news);

    ServerResponse reviseNews(News news);

    ServerResponse deleteNews(Integer id);

    ServerResponse searchNewType();

    ServerResponse searchType(Integer typeId);
}
