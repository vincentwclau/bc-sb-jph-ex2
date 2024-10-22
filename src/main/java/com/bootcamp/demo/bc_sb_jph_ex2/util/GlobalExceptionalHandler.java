package com.bootcamp.demo.bc_sb_jph_ex2.util;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

public class GlobalExceptionalHandler {
  @ExceptionHandler({BusinessException.class})
  @ResponseStatus(value = HttpStatus.BAD_REQUEST)
  public ApiResp<Void> businessExceptionHandler(BusinessException e) {
    return ApiResp.<Void>builder() //
        .fail(e) //
        .build();
  }
}
