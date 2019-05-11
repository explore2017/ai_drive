package com.explore.controller;

import com.explore.common.ServerResponse;
import com.explore.pojo.Subject;
import com.explore.service.ISubjectService;
import org.springframework.beans.factory.annotation.Autowired;
<<<<<<< HEAD
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
=======
import org.springframework.web.bind.annotation.*;
>>>>>>> c554e7846a6e71ad97f915f266fb3c769bd3d6c1

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
<<<<<<< HEAD

=======
        ServerResponse serverResponse = SubjectService.addSubject(subject);
>>>>>>> c554e7846a6e71ad97f915f266fb3c769bd3d6c1
        return ServerResponse.createBySuccessMessage("success");
    }

    /**
     * 展示所有科目
     * @return
     */
<<<<<<< HEAD
    @PostMapping("/showSubjects")
    public ServerResponse showSubjects() {

        return ServerResponse.createBySuccessMessage("success");
    }

    /**
     * 展示单个科目
     * @return
     */
    @PostMapping("/showSubject")
    public ServerResponse showSubject(@RequestBody Subject subject) {

        return ServerResponse.createBySuccessMessage("success");
=======
    @GetMapping("/showSubject")
    public ServerResponse showSubjects() {
        ServerResponse serverResponse = SubjectService.showSubject();
        return serverResponse;
>>>>>>> c554e7846a6e71ad97f915f266fb3c769bd3d6c1
    }

    /**
     * 修改科目
     * @return
     */
<<<<<<< HEAD
    @PostMapping("/reviseSubject")
    public ServerResponse reviseSubject(@RequestBody Subject subject, int id) {

        return ServerResponse.createBySuccessMessage("success");
=======
    @PutMapping("/reviseSubject")
    public ServerResponse reviseSubject(Subject subject) {
        ServerResponse serverResponse = SubjectService.reviseSubject(subject);
        return serverResponse;
>>>>>>> c554e7846a6e71ad97f915f266fb3c769bd3d6c1
    }

    /**
     * 删除科目
     * @return
     */
<<<<<<< HEAD
    @PostMapping("/deleteSubject")
    public ServerResponse deleteSubject(@RequestBody Subject subject) {

=======
    @PostMapping("/deleteExam/{id}")
    public ServerResponse deleteExam(@PathVariable("id") Integer id) {
        ServerResponse serverResponse = SubjectService.deleteExam(id);
>>>>>>> c554e7846a6e71ad97f915f266fb3c769bd3d6c1
        return ServerResponse.createBySuccessMessage("success");
    }
}
