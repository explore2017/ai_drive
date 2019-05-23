package com.explore.controller;

import com.explore.common.ServerResponse;
import com.explore.pojo.Staff;
import com.explore.service.IStaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author PinTeh
 * @date 2019/5/20
 */
@RestController
@RequestMapping("/staff")
public class StaffController {

    @Autowired
    private IStaffService iStaffService;

    @PostMapping("/")
    public ServerResponse save(@RequestBody Staff staff){
        return iStaffService.save(staff);
    }
    @PutMapping("/")
    public ServerResponse modify(@RequestBody Staff staff){
        return iStaffService.modify(staff);
    }

    @GetMapping("/")
    public ServerResponse all(){
        return iStaffService.findAll();
    }

    @GetMapping("/{id}")
    public ServerResponse get(@PathVariable("id") Integer id){
        return iStaffService.findById(id);
    }

    @DeleteMapping("/{id}")
    public ServerResponse del(@PathVariable("id") Integer id){
        return iStaffService.deleteById(id);
    }


}
