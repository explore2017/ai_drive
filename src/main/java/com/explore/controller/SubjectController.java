//package com.explore.controller;
//
//import com.explore.common.ServerResponse;
//import com.explore.pojo.Subject;
//import com.explore.service.ISubjectService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping("/subject")
//public class SubjectController {
//
//    @Autowired
//    ISubjectService SubjectService;
//
//
//    /**
//     * 添加科目
//     * @param subject
//     * @return
//     */
//    @PostMapping("/addSubject")
//    public ServerResponse addSubject(@RequestBody Subject subject) {
//
//        return ServerResponse.createBySuccessMessage("success");
//    }
//
//    /**
//     * 展示所有科目
//     * @return
//     */
//    @PostMapping("/showSubject")
//    public ServerResponse showSubjects() {
//
//        return ServerResponse.createBySuccessMessage("success");
//    }
//
//    /**
//     * 展示单个科目
//     * @return
//     */
//    @PostMapping("/showSubject")
//    public ServerResponse showSubject(@RequestBody Subject subject) {
//
//        return ServerResponse.createBySuccessMessage("success");
//    }
//
//    /**
//     * 修改科目
//     * @return
//     */
//    @PostMapping("/reviseSubject")
//    public ServerResponse reviseSubject(@RequestBody Subject subject, int id) {
//
//        return ServerResponse.createBySuccessMessage("success");
//    }
//
//    /**
//     * 删除科目
//     * @return
//     */
//    @PostMapping("/deleteExam")
//    public ServerResponse deleteExam(@RequestBody Subject subject) {
//
//        return ServerResponse.createBySuccessMessage("success");
//    }
//}
