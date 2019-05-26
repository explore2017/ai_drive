package com.explore.controller;

import com.explore.common.Const;
import com.explore.common.ServerResponse;
import com.explore.common.UnAuthorizedException;
import com.explore.pojo.Manage;
import com.explore.pojo.Staff;
import com.explore.pojo.Student;
import com.explore.service.*;
import org.apache.catalina.Server;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * @author PinTeh
 * @date 2019/5/12
 */
@RestController
public class CommonController {

    @Autowired
    private IStudentService studentService;
    @Autowired
    private ICoachService coachService;
    @Autowired
    private IVehicleService vehicleService;
    @Autowired
    private ISourceService sourceService;
    @Autowired
    private ICampusService campusService;
    @Autowired
    private IStaffService staffService;

    /**
     * 获取当前用户
     * @param session
     * @return
     */
    @GetMapping("/fetchCurrent")
    public Map fetchCurrent(HttpSession session) throws UnAuthorizedException {
        String qqAvatar = "http://q1.qlogo.cn/g?b=qq&nk=2312333700&s=100";
        Object attribute = session.getAttribute(Const.CURRENT_USER);
        Map<String,Object> map = new HashMap<>(3);
        if (attribute==null){
            throw new UnAuthorizedException();
        }
        if (attribute instanceof Staff){
            Staff staff = (Staff) attribute;
            map.put("name",staff.getName());
            map.put("type","admin");
            map.put("entity",staff);
        }else if (attribute instanceof Student){
            Student student = (Student) attribute;
            Map<String,Object> ret = new HashMap<>();
            ret.put("coach",coachService.findById(student.getCoachId()));
            ret.put("campus",campusService.findById(student.getCampusId()));
            map.put("name",student.getName());
            map.put("type","student");
            map.put("entity",student);
            map.put("entityMore",ret);
        }
        map.put("avatar",qqAvatar);
        return map;
    }

    /**
     * 统计
     * @return
     */
    @GetMapping("/count")
    public ServerResponse count(){
        Map<String,Integer> map = new HashMap<>(10);
        map.put("student",studentService.allCount());
        map.put("coach",coachService.allCount());
        map.put("campus",campusService.allCount());
        map.put("source",sourceService.allCount());
        map.put("vehicle",vehicleService.allCount());
        map.put("staff",staffService.allCount());
        return ServerResponse.createBySuccess(map);
    }
}
