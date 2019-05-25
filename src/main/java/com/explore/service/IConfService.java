package com.explore.service;

import com.explore.common.ServerResponse;
import com.explore.pojo.Conf;

/**
 * @author PinTeh
 * @date 2019/5/25
 */
public interface IConfService {
    
    ServerResponse save(Conf conf);
    
    ServerResponse update(Conf conf);

    ServerResponse delete(Integer id);

    ServerResponse sources();

    ServerResponse emp();
}
