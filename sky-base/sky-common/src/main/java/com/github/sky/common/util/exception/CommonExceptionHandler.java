package com.github.sky.common.util.exception;

import com.github.sky.common.util.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @Auther: haoxin
 * @Date: 2018-10-9 13:39
 * @Description:统一异常处理
 */
@RestControllerAdvice
@Slf4j
public class CommonExceptionHandler {
    /**
     * 业务异常
     */
    @ExceptionHandler(RRException.class)
    public R handleRRException(RRException e) {
        log.error(e.toString());
        e.printStackTrace();
        return R.error(e.getCode(),e.getMsg());
    }

    @ExceptionHandler(Exception.class)
    public R handleException(Exception e) {
        log.error(e.toString());
        e.printStackTrace();
        return R.error(e.getMessage());
    }
}
