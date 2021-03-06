package com.explore.controller;


import com.explore.common.ServerResponse;
import com.explore.pojo.Source;
import com.explore.service.ISourceService;
import com.explore.service.IVehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/source")
public class SourceController {

    @Autowired
    ISourceService sourceService;


    /**
     * 添加资源
     * @param source
     * @return
     */
    @PostMapping("/addSource")
    public ServerResponse addSource(@RequestBody Source source) {
        ServerResponse serverResponse = sourceService.addSource(source);
        return serverResponse;
    }

    /**
     * 展现所有资源
     * @return
     */
    @GetMapping("/showSources")
    public ServerResponse showSources() {
        ServerResponse serverResponse = sourceService.showSources();
        return serverResponse;
    }

    /**
     * 展现所有资源
     * @return
     */
    @PostMapping("/showSource")
    public ServerResponse showSource(@RequestBody Source source) {
        ServerResponse serverResponse = sourceService.showSource(source);
        return serverResponse;
    }

    /**
     * 修改资源信息
     * @param source
     * @return
     */
    @PutMapping("/reviseSource")
    public ServerResponse reviseSource(@RequestBody Source source) {
        ServerResponse serverResponse = sourceService.reviseSource(source);
        return serverResponse;
    }

    /**
     * 删除资源
     * @return
     */
    @DeleteMapping("/deleteSource/{id}")
    public ServerResponse deleteSource(@PathVariable("id") Integer id) {
        ServerResponse serverResponse = sourceService.deleteSource(id);
        return serverResponse;
    }
}
