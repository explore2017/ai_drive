package com.explore.controller.manage;

import com.explore.common.Const;
import com.explore.common.LoginResponse;
import com.explore.common.ServerResponse;
import com.explore.form.AddSubjectStudent;
import com.explore.form.LoginForm;
import com.explore.pojo.*;
import com.explore.service.IManageService;
import com.explore.service.ISubjectStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/manage")
public class ManageController {

    @Autowired
    IManageService manageService;
    @Autowired
    ISubjectStudentService subjectStudentService;

    /**
     * 管理员登录
     */
    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginForm user, HttpSession session) {
        ServerResponse<Staff> serverResponse = manageService.login(user.getUserName(),user.getPassword());
        if (serverResponse.isSuccess()) {
            session.setAttribute(Const.CURRENT_USER,serverResponse.getData());
            return new LoginResponse("ok","admin","admin");
        }
        return new LoginResponse("error","guest","admin");
    }

    /**
     * 管理员密码修改
     */
    @PutMapping("/password")
    public ServerResponse revise(String name, String oldPassword, String newPassword) {
        ServerResponse serverResponse = manageService.revise(name, oldPassword, newPassword);
        return serverResponse;
    }

    /**
     * 查看所有学生数据
     */
    @GetMapping("/students")
    public ServerResponse getAllStudent(){
        ServerResponse serverResponse=manageService.Students();
        return serverResponse;
    }


    /**
     * 学生添加
     *  @param student
     */
    @PostMapping("/insertStudent")
    public ServerResponse addStudent(@RequestBody Student student) {
        ServerResponse serverResponse = manageService.addStudent(student);
        return serverResponse;
    }

    /**
     * @param id
     * 学生删除
     */
    @DeleteMapping("/deleteStudent/{id}")
    public ServerResponse outStudent(@PathVariable("id") Integer id) {
        ServerResponse serverResponse = manageService.outStudent(id);
        return serverResponse;
    }

    /**
     * @param student
     * 修改学生信息
     */
    @PutMapping("/reviseStudent")
    public ServerResponse reviseStudent(@RequestBody Student student) {
        ServerResponse serverResponse = manageService.reviseStudent(student);
        return serverResponse;
    }

    /**
     * 添加学员考试信息
     */
    @PostMapping("/addSubjectStudent")
    public ServerResponse addSubjectStudent(@RequestBody AddSubjectStudent addSubjectStudent) {
        ServerResponse serverResponse = subjectStudentService.addSubjectStudent(addSubjectStudent);
        return serverResponse;
    }

    /**
     * 展示所有学员考试信息
     */
    @PostMapping("/showSubjectStudent")
    public ServerResponse showSubjectStudent() {
        ServerResponse serverResponse = subjectStudentService.showSubjectStudent();
        return serverResponse;
    }

    /**
     * 展示所有学员考试信息
     */
    @PostMapping("/showStudentExam")
    public ServerResponse showStudentExam(@RequestBody Student student) {
        ServerResponse serverResponse = subjectStudentService.showStudentExam(student);
        return serverResponse;
    }

    /**
     * 修改单个学员考试信息
     */
    @PostMapping("/reviewSubjectStudent")
    public ServerResponse reviewSubjectStudent(@RequestBody SubjectStudent subjectStudent) {
        ServerResponse serverResponse = subjectStudentService.reviewSubjectStudent(subjectStudent);
        return serverResponse;
    }

    /**
     * 删除单个学员考试信息
     */
    @DeleteMapping("/deleteSubjectStudent/{id}")
    public ServerResponse deleteSubjectStudent(@PathVariable("id") Integer id) {
        ServerResponse serverResponse = subjectStudentService.deleteSubjectStudent(id);
        return serverResponse;
    }

    /**
     * 同意单个学员考试信息录入
     */
    @PostMapping("/acceptSubjectStudent")
        public ServerResponse acceptSubjectStudent(@RequestBody SubjectStudent subjectStudent) {
        ServerResponse serverResponse = subjectStudentService.acceptSubjectStudent(subjectStudent);
        return serverResponse;
    }

    /**
     * 确认单个学员考试通过
     */
    @PostMapping("/passSubjectStudent")
    public ServerResponse passSubjectStudent(@RequestBody SubjectStudent subjectStudent) {
        ServerResponse serverResponse = subjectStudentService.passSubjectStudent(subjectStudent);
        return serverResponse;
    }

    /**
     * 查看所有教练数据
     */
    @GetMapping("/Coaches")
    public ServerResponse getAllCoach(){
        ServerResponse serverResponse=manageService.Coaches();
        return serverResponse;
    }

    /**
     * @param coach
     * 教练添加
     */
    @PostMapping("/insertTeacher")
    public ServerResponse addTeacher(@RequestBody Coach coach) {
        ServerResponse serverResponse = manageService.addCoach(coach);
        return serverResponse;
    }


    /**
     * 教练删除
     */
    @DeleteMapping("/deleteTeacher/{id}")
    public ServerResponse outTeacher(@PathVariable("id") Integer id) {
        ServerResponse serverResponse = manageService.outCoach(id);
        return serverResponse;
    }

    /**
     * 修改教练信息
     */
    @PutMapping("/reviseTeacher")
    public ServerResponse reviseTeacher(@RequestBody Coach coach) {
        ServerResponse serverResponse = manageService.reviseCoach(coach);
        return serverResponse;
    }
    /**
     * 查看所有校区
     */
    @GetMapping("/showAllCampus")
    public ServerResponse showAllCampus(){
        ServerResponse serverResponse = manageService.showAllCampus();
        return serverResponse;
    }
    /**
     * 查看所有考试科目
     */
    @GetMapping("/showAllSubject")
    public ServerResponse showAllSubject(){
        ServerResponse serverResponse = manageService.showAllSubject();
        return serverResponse;
    }
}
