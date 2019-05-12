package com.explore.controller;

import com.explore.common.ServerResponse;
import com.explore.pojo.Subject;
import com.explore.service.ISubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/subject")
public class SubjectController {

    @Autowired
    ISubjectService SubjectService;

    /**
     * 添加科目
     * @param subject
     * @return
     */
    @PostMapping("/addSubject")
    public ServerResponse addSubject(@RequestBody Subject subject) {
        ServerResponse serverResponse = SubjectService.addSubject(subject);
        return serverResponse;
    }

    /**
     * 展示单个科目
     * @return
     */
    @GetMapping("/showSubject")
    public ServerResponse showSubjects() {
        ServerResponse serverResponse = SubjectService.showSubject();
        return serverResponse;
    }

    /**
     * 修改科目
     * @return
     */
    @PutMapping("/reviseSubject")
    public ServerResponse reviseSubject(Subject subject) {
        ServerResponse serverResponse = SubjectService.reviseSubject(subject);
        return serverResponse;
    }

    /**
     * 删除科目
     * @return
     */
    @PostMapping("/deleteExam/{id}")
    public ServerResponse deleteExam(@PathVariable("id") Integer id) {
        ServerResponse serverResponse = SubjectService.deleteExam(id);
        return serverResponse;
    }
}
