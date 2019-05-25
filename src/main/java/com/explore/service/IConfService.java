package com.explore.service;

import com.explore.common.ServerResponse;
import com.explore.pojo.Conf;
import com.explore.vo.ConfVo;

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

    ServerResponse updateByCodeAndCampusId(ConfVo confVo);
}
