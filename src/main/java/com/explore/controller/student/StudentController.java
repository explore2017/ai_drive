package com.explore.controller.student;

import com.explore.common.Const;
import com.explore.common.LoginResponse;
import com.explore.common.ResponseCode;
import com.explore.common.ServerResponse;
import com.explore.form.AddSubjectStudent;
import com.explore.form.LoginForm;
import com.explore.form.PasswordForm;
import com.explore.pojo.*;
import com.explore.service.ISubjectStudentService;
import com.explore.service.Impl.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import com.explore.service.IStudentService;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    IStudentService studentService;

    @Autowired
    ISubjectStudentService subjectStudentService;


    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginForm user, HttpSession session) {
        ServerResponse serverResponse = studentService.login(user.getUserName(),user.getPassword());
        if (serverResponse.isSuccess()) {
            session.setAttribute(Const.CURRENT_USER,serverResponse.getData());
            return new LoginResponse("ok","student","student");
        }
        return new LoginResponse("error","guest","student");
    }

    @PutMapping("/info")
    public ServerResponse changePhone(@RequestBody Student params,HttpSession session){
        Object object = session.getAttribute(Const.CURRENT_USER);
        if (object==null){
            return ServerResponse.needLogin();
        }
        Student student = (Student) object;
        Student modify = new Student();
        modify.setId(student.getId());
        modify.setPhone(params.getPhone());
        //方法可复用
        ServerResponse serverResponse = studentService.modify(modify);
        if (serverResponse.isSuccess()){
            //更新session
            student.setPhone(params.getPhone());
            session.setAttribute(Const.CURRENT_USER,student);
        }
        return serverResponse;
    }

    @PutMapping("/password")
    public ServerResponse changePhone(@RequestBody PasswordForm params, HttpSession session){
        Object object = session.getAttribute(Const.CURRENT_USER);
        if (object==null){
            return ServerResponse.needLogin();
        }
        Student student = (Student) object;
        return studentService.modifyPassword(params,student.getId());
    }

    @PostMapping("/sign")
    public ServerResponse sign(@RequestBody SubjectStudent subjectStudent,HttpSession session) {
        Student student = (Student)session.getAttribute(Const.CURRENT_USER);
        if (student==null){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(),"请登录后尝试");
        }
        subjectStudent.setStudentId(student.getId());
        return subjectStudentService.sign(subjectStudent);
    }

    @GetMapping("/exam")
    public ServerResponse exam(HttpSession session) {
        Object object = session.getAttribute(Const.CURRENT_USER);
        if (object==null){
            return ServerResponse.needLogin();
        }
        Student student = (Student) object;
        return subjectStudentService.findByStudentId(student.getId());
    }

    @PutMapping("/exam/cancel/{id}")
    public ServerResponse cancel(@PathVariable("id")Integer id,HttpSession session) {
        Object object = session.getAttribute(Const.CURRENT_USER);
        if (object==null){
            return ServerResponse.needLogin();
        }
        Student student = (Student) object;
        return subjectStudentService.cancel(student.getId(),id);
    }

    /**
     * 展现该学员个人信息(包含是否拿到驾照)
     * @return
     */
    @PostMapping("/show")
    public ServerResponse showMessage(String name,String idcard) {
        return studentService.showMessage(name,idcard);
    }

    /**
     * 展现该学员所有考试信息
     * @param student
     * @return
     */
    @GetMapping("/showExams")
    public ServerResponse showExams(@RequestBody Student student) {
        ServerResponse<List<SubjectStudent>> serverResponse = studentService.showExam(student.getId());
        return serverResponse;
    }

    /**
     * 学员选择教练
     * @param coach
     * @return
     */
    @PutMapping("/selectCoach")
    public ServerResponse selectCoach(@RequestBody Coach coach,HttpSession session) {
        Object object = session.getAttribute(Const.CURRENT_USER);
        if (object==null){
            return ServerResponse.needLogin();
        }
        Student student = (Student) object;
        if(student.getCoachId()!=null){
            return ServerResponse.createByErrorMessage("选择失败，您已经选择过教练了,如需重新选择，请联系工作人员。");
        }
        return studentService.addCoach(student,coach);
    }

    /**
     * 学员归入某个教练
     * @param student
     * @param coach
     * @return
     */
    @PutMapping("/addCoach")
    public ServerResponse addCoach(@RequestBody Student student,@RequestBody Coach coach) {
        ServerResponse serverResponse = studentService.addCoach(student,coach);
        return serverResponse;
    }

    /**
     * 修改学员所属校区
     * @param student
     * @return
     */
    @PutMapping("/reviseCampus")
    public ServerResponse reviseCampus(@RequestBody Student student, int  campus_id) {
        ServerResponse serverResponse = studentService.reviseCampus(student,campus_id);
        return serverResponse;
    }

    /**
     * 学员提交考试信息
     * @param addSubjectStudent
     * @return
     */
    @PostMapping("/addSubjectStudent")
    public ServerResponse addSubjectStudent(@RequestBody AddSubjectStudent addSubjectStudent) {
        ServerResponse serverResponse = subjectStudentService.addSubjectStudent(addSubjectStudent);
        return serverResponse;
    }

    @PostMapping("/addSubjectStudent2")
    public ServerResponse addSubjectStudent(@RequestBody Student student, SubjectStudent subjectStudent) {
        ServerResponse serverResponse = studentService.addSubjectStudent(student,subjectStudent);
        return serverResponse;
    }

}
