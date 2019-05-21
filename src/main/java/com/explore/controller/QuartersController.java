package com.explore.controller;


import com.explore.common.ServerResponse;
import com.explore.service.IQuartersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/quarters")
public class QuartersController {

    @Autowired
    IQuartersService quartersService;
    /**
     * 查看所有季度
     * @return
     */
    @GetMapping
    public ServerResponse searchAllQuarters()
    {
        ServerResponse serverResponse = quartersService.searchAllQuarters();
        return  serverResponse;
    }

    @GetMapping
    public  ServerResponse
}
