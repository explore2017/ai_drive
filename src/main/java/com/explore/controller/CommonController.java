package com.explore.controller;

import com.explore.common.Const;
import com.explore.common.ServerResponse;
import com.explore.pojo.Manage;
import com.explore.pojo.Staff;
import com.explore.pojo.Student;
import org.apache.catalina.Server;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
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

    @GetMapping("/fetchCurrent")
    public Map fetchCurrent(HttpSession session){
        String qqAvatar = "http://q1.qlogo.cn/g?b=qq&nk=2312333700&s=100";
        Object attribute = session.getAttribute(Const.CURRENT_USER);
        Map<String,Object> map = new HashMap<>(3);
        if (attribute==null){
            return null;
        }
        if (attribute instanceof Staff){
            Staff staff = (Staff) attribute;
            map.put("name",staff.getName());
            map.put("type","admin");
            map.put("entity",staff);
        }else if (attribute instanceof Student){
            Student student = (Student) attribute;
            map.put("name",student.getName());
            map.put("type","student");
            map.put("entity",student);
        }
        map.put("avatar",qqAvatar);
        return map;
    }
}
