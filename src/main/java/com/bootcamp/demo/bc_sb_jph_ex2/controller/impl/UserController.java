package com.bootcamp.demo.bc_sb_jph_ex2.controller.impl;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.bootcamp.demo.bc_sb_jph_ex2.controller.UserOperation;
import com.bootcamp.demo.bc_sb_jph_ex2.dto.request.UserReqDto;
import com.bootcamp.demo.bc_sb_jph_ex2.dto.response.UserRespDto;
import com.bootcamp.demo.bc_sb_jph_ex2.entity.UserEntity;
import com.bootcamp.demo.bc_sb_jph_ex2.mapper.UserMapper;
import com.bootcamp.demo.bc_sb_jph_ex2.service.UserService;
import com.bootcamp.demo.bc_sb_jph_ex2.util.ApiResp;

@RestController
public class UserController implements UserOperation {
  @Autowired
  private UserMapper userMapper;

  @Autowired
  private UserService userService;

  @Override
  public ApiResp<List<UserRespDto>> getUsers() {
    List<UserRespDto> userRespDtos = this.userService.getAll().stream() //
        .map(e -> this.userMapper.map(e)) //
        .collect(Collectors.toList());
    return ApiResp.<List<UserRespDto>>builder() //
        .ok() //
        .data(userRespDtos) //
        .build();
  }

  @Override
  public ApiResp<UserRespDto> getUser(Long id) {
    UserEntity userEntity = this.userService.getById(id);
    UserRespDto userRespDto = this.userMapper.map(userEntity);
    return ApiResp.<UserRespDto>builder() //
        .ok() //
        .data(userRespDto) //
        .build();
  }

  @Override
  public ApiResp<UserRespDto> updateUser(Long id, UserReqDto user) {
    UserEntity userEntity = this.userMapper.map(user);
    userEntity = this.userService.updateById(id, userEntity);
    UserRespDto userRespDto = this.userMapper.map(userEntity);
    return ApiResp.<UserRespDto>builder() //
        .ok() //
        .data(userRespDto) //
        .build();
  }
}
