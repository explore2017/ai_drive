package com.explore.service;

import com.explore.common.ServerResponse;
import com.explore.pojo.Subject;

public interface ISubjectService {

    ServerResponse addSubject(Subject subject);

    ServerResponse showSubject();

    ServerResponse reviseSubject(Subject subject);

    ServerResponse deleteExam(Integer id);
}
