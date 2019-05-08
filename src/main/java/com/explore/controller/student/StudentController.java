package com.explore.controller.student;

import com.explore.common.ServerResponse;
import com.explore.pojo.*;
import com.explore.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    IStudentService studentService;

    /**
     * 展现该学员个人信息(包含是否拿到驾照)
     * @return
     */
    @PostMapping("/show")
    public ServerResponse showMessage(String name,String idcard) {
        ServerResponse serverResponse = studentService.showMessage(name,idcard);
        return serverResponse;
    }

    /**
     * 展现该学员所有考试信息
     * @param student
     * @return
     */
    @GetMapping("/showExams")
    public ServerResponse showExams(Student student) {
        ServerResponse<List<SubjectStudent>> serverResponse = studentService.showExam(student.getId());
        return serverResponse;
    }


    /**
     * 学员归入某个教练
     * @param student
     * @param coach
     * @return
     */
    @PutMapping("/addCoach")
    public ServerResponse addCoach(Student student, Coach coach) {
        ServerResponse serverResponse = studentService.addCoach(student,coach);
        return serverResponse;
    }

    /**
     * 修改学员所属校区
     * @param student
     * @return
     */
    @PutMapping("/reviseCampus")
    public ServerResponse reviseCampus(Student student, int  campus_id) {
        ServerResponse serverResponse = studentService.reviseCampus(student,campus_id);
        return serverResponse;
    }

    /**
     * 学员提交考试信息
     * @param student
     * @param subjectStudent
     * @return
     */
    @PostMapping("/addSubjectStudent")
    public ServerResponse addSubjectStudent(@RequestBody Student student, SubjectStudent subjectStudent) {
        ServerResponse serverResponse = studentService.addSubjectStudent(student,subjectStudent);
        return serverResponse;
    }

}
