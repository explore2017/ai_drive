package com.explore.common;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author PinTeh
 * @date 2019/5/26
 */
@ControllerAdvice
@Slf4j
public class GlobalException {

    @ExceptionHandler(UnAuthorizedException.class)
    @ResponseStatus(code = HttpStatus.UNAUTHORIZED,reason = "请登录后尝试")
    public void unAuthorizedException(){
        log.info("未登录请求");
    }
}
