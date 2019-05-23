package com.explore.service;


import com.explore.common.ServerResponse;
import com.explore.pojo.Coach;

public interface ICoachService {

    ServerResponse showStudent(Integer coachId);

    ServerResponse reviseCampus(Coach coach);

    ServerResponse searchSubjectStudent(Integer coachId);

    Integer allCount();
}
