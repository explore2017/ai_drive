package com.explore.controller.student;

import com.explore.common.ServerResponse;
import com.explore.dao.SubjectStudentMapper;
import com.explore.form.AddSubjectStudent;
import com.explore.pojo.*;
import com.explore.service.ISubjectStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    ISubjectStudentService subjectStudentService;

    /**
     * 展现该学员个人信息(包含是否拿到驾照)
     * @param student
     * @return
     */
    @PostMapping("/show")
    public ServerResponse showStudents(@RequestBody Student student) {

        return ServerResponse.createBySuccessMessage("success");
    }

    /**
     * 展现该学员所有考试信息
     * @param student
     * @return
     */
    @PostMapping("/showExams")
    public ServerResponse showExams(@RequestBody Student student) {

        return ServerResponse.createBySuccessMessage("success");
    }

    /**
     * 学员加入校区
     * @param student
     * @param campus
     * @return
     */
    @PostMapping("/addCampus")
    public ServerResponse addCampus(@RequestBody Student student, Campus campus) {
    // 考虑是否可以在归入教练时自动加入校区

        return ServerResponse.createBySuccessMessage("success");
    }

    /**
     * 学员归入某个教练
     * @param student
     * @param coach
     * @return
     */
    @PostMapping("/addCoach")
    public ServerResponse addCoach(@RequestBody Student student, Coach coach) {

        return ServerResponse.createBySuccessMessage("success");
    }

    /**
     * 修改学员所属校区
     * @param student
     * @param campus
     * @return
     */
    @PostMapping("/reviseCampus")
    public ServerResponse reviseCampus(@RequestBody Student student, Campus campus) {

        return ServerResponse.createBySuccessMessage("success");
    }

    /**
     * 学员提交考试信息
     * @param addSubjectStudent
     * @return
     */
    @PostMapping("/addSubjectStudent")
//    public ServerResponse addSubjectStudent(SubjectStudent subjectStudent, String phone, String idcard) {
    public ServerResponse addSubjectStudent(@RequestBody AddSubjectStudent addSubjectStudent) {
        ServerResponse serverResponse = subjectStudentService.addSubjectStudent(addSubjectStudent);
        return serverResponse;
    }

    @PostMapping("/addSubjectStudent2")
    public ServerResponse tt (String phone, String idcard, String position, Date date) {

        return ServerResponse.createBySuccess();
    }

    /**
     * 退出某个教练教学
     * @param student
     * @param coach
     * @return
     */
    @DeleteMapping("/deleteStudent")
    public ServerResponse deleteStudent(Student student, Coach coach) {

        return ServerResponse.createBySuccessMessage("success");
    }
}
