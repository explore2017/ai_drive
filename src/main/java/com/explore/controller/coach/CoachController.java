package com.explore.controller.coach;


import com.explore.common.ServerResponse;
import com.explore.pojo.*;
import com.explore.service.ICoachService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/coach")
public class CoachController {

    @Autowired
    ICoachService coachService;

    /**
     * 展现该教练当前所教未拿驾照的学员
     * @param coach
     * @return
     */
    @GetMapping("/showStudents")
    public ServerResponse showStudents(@RequestBody Coach coach) {
        ServerResponse serverResponse = coachService.showStudent(coach.getId());
        return serverResponse;
    }

    /**
     * 修改教练所属校区
     * @param coach
     * @return
     */
    @PutMapping("/reviseCampus")
    public ServerResponse reviseCampus(@RequestBody Coach coach, Integer campus_id) {
        coach.setCampusId(campus_id);
        ServerResponse serverResponse = coachService.reviseCampus(coach);
        return serverResponse;
    }

    /**
     * 教练查看所教所有学员考试信息
     * @param coach
     * @return
     */
    @GetMapping("/searchSubjectStudent")
    public ServerResponse searchExam(@RequestBody Coach coach) {
        ServerResponse serverResponse = coachService.searchSubjectStudent(coach.getId());
        return serverResponse;
    }

}
