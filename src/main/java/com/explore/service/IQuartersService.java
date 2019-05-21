package com.explore.service;

import com.explore.common.ServerResponse;
import com.explore.pojo.Quarters;

public interface IQuartersService {

    ServerResponse searchAllQuarters();

    ServerResponse searchThreeQuarters();

    ServerResponse reviseQuarters(Quarters quarters);
}
