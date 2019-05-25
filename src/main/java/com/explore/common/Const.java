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

    /**
     * 配置类型
     */
    public enum  CONF_TYPE{
        //
        VEHICLE(2000,"车辆配置"),
        SOURCE(2001,"物资配置"),
        COACH(3001,"教练配置"),
        STUDENT(3002,"学员配置"),
        STAFF(3003,"员工配置");

        private int code;
        private String desc;

        CONF_TYPE(int code, String desc) {
            this.code = code;
            this.desc = desc;
        }

        public int getCode() {
            return code;
        }

        public void setCode(int code) {
            this.code = code;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }}
}
