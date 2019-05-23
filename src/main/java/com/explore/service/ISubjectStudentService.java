package com.explore.service;


import com.explore.common.ServerResponse;
import com.explore.form.AddSubjectStudent;
import com.explore.pojo.Student;
import com.explore.pojo.StudentExam;
import com.explore.pojo.SubjectStudent;

public interface ISubjectStudentService {

    ServerResponse addSubjectStudent(AddSubjectStudent addSubjectStudent);

    ServerResponse showSubjectStudent();

    ServerResponse reviewSubjectStudent(SubjectStudent subjectStudent);

    ServerResponse acceptSubjectStudent(SubjectStudent subjectStudent);

    ServerResponse passSubjectStudent(SubjectStudent subjectStudent);

    ServerResponse deleteSubjectStudent( int id);

    ServerResponse showStudentExam(StudentExam studentExam);

    ServerResponse sign(SubjectStudent subjectStudent);
}
