package com.explore.common;

/**
 * @author PinTeh
 * @date 2019/5/26
 */
public class UnAuthorizedException extends Exception{

    public UnAuthorizedException() {

    }

    public UnAuthorizedException(String msg){
        super(msg);
    }
}
