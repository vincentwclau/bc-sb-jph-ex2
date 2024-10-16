package com.bootcamp.demo.bc_sb_jph_ex2.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bootcamp.demo.bc_sb_jph_ex2.entity.UserEntity;
import com.bootcamp.demo.bc_sb_jph_ex2.repository.UserRepository;
import com.bootcamp.demo.bc_sb_jph_ex2.service.UserService;

@Service
public class UserServiceImpl implements UserService {
  @Autowired
  private UserRepository userRepository;

  @Override
  public List<UserEntity> saveAll(List<UserEntity> userEntity) {
    return userRepository.saveAll(userEntity);
  }
}
