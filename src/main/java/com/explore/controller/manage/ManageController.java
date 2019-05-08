package com.explore.controller.manage;

import com.explore.common.Const;
import com.explore.common.ServerResponse;
import com.explore.pojo.Coach;
import com.explore.pojo.Student;
import com.explore.service.IManageService;
import org.apache.catalina.Manager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/manage")
public class ManageController {

    @Autowired
    IManageService manageService;

    /**
     * 管理员登录
     */
    @PostMapping("/login")
    public ServerResponse login(@RequestBody String username, String password, HttpSession session) {
        ServerResponse<Manager> serverResponse = manageService.login(username, password);
        if (serverResponse.isSuccess()) {
            Manager manager = serverResponse.getData();
            session.setAttribute(Const.CURRENT_USER,manager);
        }
        return serverResponse;
    }

    /**
     * 管理员密码修改
     */
    @PutMapping("/password")
    public ServerResponse revise(String username, String oldPassword, String newPassword) {
        ServerResponse serverResponse = manageService.revise(username, oldPassword, newPassword);
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
    public ServerResponse reviseStudent(Student student) {
        ServerResponse serverResponse = manageService.reviseStudent(student);
        return serverResponse;
    }

    /**
     * 查看所有教练数据
     */
    @GetMapping("/Coaches")
    public ServerResponse getAllCoach(){
        ServerResponse serverResponse=manageService.Coachs();
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
    public ServerResponse reviseTeacher( Coach coach) {
        ServerResponse serverResponse = manageService.reviseCoach(coach);
        return serverResponse;
    }

}
