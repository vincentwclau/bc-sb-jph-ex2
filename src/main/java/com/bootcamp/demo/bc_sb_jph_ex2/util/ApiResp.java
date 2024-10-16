package com.bootcamp.demo.bc_sb_jph_ex2.util;

import java.util.List;

public class ApiResp<T> {
  private String code;
  private String message;
  private List<T> data;

  public String code(String code) {
    return this.code;
  }

  public String message(String message) {
    return this.message;
  }

  public List<T> getData() {
    return this.data;
  }

  public static <T> Builder<T> builder() {
    return new Builder<>();
  }

  private ApiResp(Builder<T> builder) {
    this.code = builder.code;
    this.message = builder.message;
    this.data = builder.data;
  }

  public static class Builder<T> {
    private String code;
    private String message;
    private List<T> data;

    public Builder<T> code(String code) {
      this.code = code;
      return this;
    }

    public Builder<T> message(String message) {
      this.message = message;
      return this;
    }

    public Builder<T> getData(List<T> data) {
      this.data = data;
      return this;
    }

    public ApiResp<T> build() {
      return new ApiResp<>(this);
    }
  }
}
