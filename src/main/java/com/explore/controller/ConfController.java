package com.explore.controller;

import com.explore.common.ServerResponse;
import com.explore.pojo.Conf;
import com.explore.service.IConfService;
import com.explore.vo.ConfVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author PinTeh
 * @date 2019/5/25
 */
@RestController
@RequestMapping("/conf")
public class ConfController {

    @Autowired
    private IConfService confService;

    @GetMapping("/sources")
    public ServerResponse sources(){
        return confService.sources();
    }

    @GetMapping("/emp")
    public ServerResponse emp(){
        return confService.emp();
    }

    @PostMapping("/")
    public ServerResponse save(@RequestBody Conf conf){
        return confService.save(conf);
    }

    @PutMapping("/")
    public ServerResponse update(@RequestBody Conf conf){
        return confService.update(conf);
    }

    @PutMapping("/update")
    public ServerResponse updateByCodeAndCampusId(@RequestBody ConfVo confVo){
        return confService.updateByCodeAndCampusId(confVo);
    }

    @DeleteMapping("/{id}")
    public ServerResponse delete(@PathVariable("id")Integer id){
        return confService.delete(id);
    }
}
