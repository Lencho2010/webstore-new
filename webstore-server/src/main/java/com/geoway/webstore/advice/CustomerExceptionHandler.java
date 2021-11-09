package com.geoway.webstore.advice;

import com.geoway.common.utils.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author Lencho
 * @create 2021-08-18 20:48
 */
@Slf4j
@RestControllerAdvice
public class CustomerExceptionHandler {

    @ExceptionHandler(Exception.class)
    public R Exception(Exception e) {
        log.error("未知异常！", e);
        return R.error(e.getMessage());
    }
}
