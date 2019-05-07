package com.explore.controller;


import com.explore.common.ServerResponse;
import com.explore.pojo.Source;
import com.explore.service.IVehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/source")
public class SourceController {

    @Autowired
    IVehicleService SourceService;


    /**
     * 添加资源
     * @param source
     * @return
     */
    @PostMapping("/addSource")
    public ServerResponse addSource(@RequestBody Source source) {

        return ServerResponse.createBySuccessMessage("success");
    }

    /**
     * 展现单个资源信息
     * @param source
     * @return
     */
    @PostMapping("/showSource")
    public ServerResponse showSource(@RequestBody Source source) {

        return ServerResponse.createBySuccessMessage("success");
    }

    /**
     * 展现所有资源
     * @return
     */
    @PostMapping("/showSources")
    public ServerResponse showSources() {

        return ServerResponse.createBySuccessMessage("success");
    }

    /**
     * 修改资源信息
     * @param source
     * @return
     */
    @PostMapping("/reviseSource")
    public ServerResponse reviseSource(Source source) {

        return ServerResponse.createBySuccessMessage("success");
    }

    /**
     * 删除资源
     * @param source
     * @return
     */
    @DeleteMapping("/deleteSource")
    public ServerResponse deleteSource(Source source) {

        return ServerResponse.createBySuccessMessage("success");
    }
}
