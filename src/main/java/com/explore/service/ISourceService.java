package com.explore.service;

import com.explore.common.ServerResponse;
import com.explore.pojo.Source;

import java.util.List;

public interface ISourceService {

    ServerResponse addSource(Source source);

    ServerResponse<List<Source>> showSources();

    ServerResponse reviseSource(Source source);

    ServerResponse deleteSource(Integer id);
}
