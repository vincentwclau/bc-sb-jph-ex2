package com.bootcamp.demo.bc_sb_jph_ex2.service;

import java.util.List;
import com.bootcamp.demo.bc_sb_jph_ex2.entity.UserEntity;

public interface UserService {
  List<UserEntity> createAll(List<UserEntity> commentEntity);

  List<UserEntity> getAll();

  UserEntity getById(Long id);

  UserEntity updateById(Long id, UserEntity userEntity);
}
