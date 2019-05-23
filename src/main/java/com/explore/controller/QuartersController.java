package com.explore.controller;


import com.explore.common.ServerResponse;
import com.explore.pojo.Quarters;
import com.explore.service.IQuartersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/quarters")
public class QuartersController {

    @Autowired
    IQuartersService quartersService;
    /**
     * 查看所有季度
     * @return
     */
    @GetMapping("/allQuarters")
    public ServerResponse searchAllQuarters()
    {
        ServerResponse serverResponse = quartersService.searchAllQuarters();
        return  serverResponse;
    }

    /**
     * 查看三个季度
     * @return
     */

    @GetMapping("/threeQuarters")
    public  ServerResponse searchThreeQuarters()
    {
        ServerResponse serverResponse = quartersService.searchThreeQuarters();
        return serverResponse;
    }

    /**
     * 修改季度
     * @param quarters
     * @return
     */
    @PutMapping("/reviseQuarters")
    public ServerResponse reviseQuarters(@RequestBody Quarters quarters)
    {
        ServerResponse serverResponse = quartersService.reviseQuarters(quarters);
        return serverResponse;
    }
}
