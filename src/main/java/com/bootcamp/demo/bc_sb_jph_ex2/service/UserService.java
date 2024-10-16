package com.bootcamp.demo.bc_sb_jph_ex2.service;

import java.util.List;
import com.bootcamp.demo.bc_sb_jph_ex2.entity.UserEntity;

public interface UserService {
  List<UserEntity> saveAll(List<UserEntity> commentEntity);
}
