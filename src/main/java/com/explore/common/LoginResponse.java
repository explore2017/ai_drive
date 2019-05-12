package com.explore.common;

import lombok.Data;

/**
 * @author PinTeh
 * @date 2019/5/12
 */
@Data
public class LoginResponse {
    private String status;

    private String currentAuthority;

    private String type;

    public LoginResponse(String status, String currentAuthority,String type) {
        this.status = status;
        this.currentAuthority = currentAuthority;
        this.type = type;
    }

    public LoginResponse(String status, String currentAuthority) {
        this.status = status;
        this.currentAuthority = currentAuthority;
        this.type = LoginCommon.TYPE;
    }

    public LoginResponse(String status) {
        this.status = status;
        this.currentAuthority = LoginCommon.AUTHORITY;
        this.type = LoginCommon.TYPE;
    }

    public LoginResponse() {

    }

    interface LoginCommon{
        String AUTHORITY = "guest";
        String TYPE = "guest";
    }
}
