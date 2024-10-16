package com.bootcamp.demo.bc_sb_jph_ex2.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionalHandler {
  @ExceptionHandler({BusinessException.class})
  @ResponseStatus(value = HttpStatus.BAD_REQUEST)
  public ErrorResp restClientExceptionHandler(BusinessException e) {
    return ErrorResp.builder() //
        .code(e.getCode()) //
        .message(e.getMessage()) //
        .build();
  }
}