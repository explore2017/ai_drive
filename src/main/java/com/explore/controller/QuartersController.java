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
<<<<<<< HEAD
    @GetMapping("allQuarters")
=======
    @GetMapping("/allQuarters")
>>>>>>> 7195003a9ebd3cb78945b24bdb94aaf094a48465
    public ServerResponse searchAllQuarters()
    {
        ServerResponse serverResponse = quartersService.searchAllQuarters();
        return  serverResponse;
    }

    /**
     * 查看三个季度
     * @return
     */
<<<<<<< HEAD
    @GetMapping("threeQuarters")
=======
    @GetMapping("/threeQuarters")
>>>>>>> 7195003a9ebd3cb78945b24bdb94aaf094a48465
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
<<<<<<< HEAD
    @PutMapping("reviseQuarters")
=======
    @PutMapping("/reviseQuarters")
>>>>>>> 7195003a9ebd3cb78945b24bdb94aaf094a48465
    public ServerResponse reviseQuarters(@RequestBody Quarters quarters)
    {
        ServerResponse serverResponse = quartersService.reviseQuarters(quarters);
        return serverResponse;
    }
}
