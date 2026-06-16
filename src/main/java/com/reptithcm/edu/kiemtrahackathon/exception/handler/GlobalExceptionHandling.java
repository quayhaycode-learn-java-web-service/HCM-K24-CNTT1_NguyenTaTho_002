package com.reptithcm.edu.kiemtrahackathon.exception.handler;

import com.reptithcm.edu.kiemtrahackathon.exception.AppException;
import com.reptithcm.edu.kiemtrahackathon.exception.ErrorCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandling {

    @ExceptionHandler(AppException.class)
    public ResponseEntity<ErrorCode> appExceptionHandler(AppException appException){
        log.error("AppException code:{} message:'{}'", appException.getErrorCode().getCode(), appException.getErrorCode().getMessage());
        return new ResponseEntity<>(appException.getErrorCode(), HttpStatus.valueOf(appException.getErrorCode().getCode()));
    }



    @ExceptionHandler(Exception.class)
    public void exceptionHandler(Exception e){
        log.error("Exception handling log: {}", e.getMessage() );
    }
}
