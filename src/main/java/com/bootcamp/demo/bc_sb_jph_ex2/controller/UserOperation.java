package com.bootcamp.demo.bc_sb_jph_ex2.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import com.bootcamp.demo.bc_sb_jph_ex2.dto.request.UserReqDto;
import com.bootcamp.demo.bc_sb_jph_ex2.dto.response.UserRespDto;
import com.bootcamp.demo.bc_sb_jph_ex2.util.ApiResp;

public interface UserOperation {
  /**
   * Read DB.
   * 
   * @return List<UserDto>
   */
  @GetMapping("/users")
  ApiResp<List<UserRespDto>> getUsers();

  /**
   * Read DB.
   * 
   * @param id
   * @return
   */
  @GetMapping("/user/{id}")
  ApiResp<UserRespDto> getUser(@RequestParam Long id);

  /**
   * Read DB.
   * 
   * @param id
   * @param user
   * @return
   */
  @PutMapping("/user/{id}")
  ApiResp<UserRespDto> updateUser(@RequestParam Long id,
      @RequestBody UserReqDto user);
}
