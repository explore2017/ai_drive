package com.explore.common;


public class Const {
    public static String CURRENT_USER = "current_user";

    public interface ExamStatus{
        //等待审核通过
        int WAIT_CHECK_PASS = 0;
        //审核通过
        int CHECK_PASS = 1;
        //审核不通过
        int CHECK_NO_PASS = 2;
        //考试通过
        int EXAM_PASS = 3;
        //考试不通过
        int EXAM_NO_PASS = 4;
    }
}
