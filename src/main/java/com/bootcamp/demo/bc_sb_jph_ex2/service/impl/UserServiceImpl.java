package com.bootcamp.demo.bc_sb_jph_ex2.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bootcamp.demo.bc_sb_jph_ex2.entity.UserEntity;
import com.bootcamp.demo.bc_sb_jph_ex2.exception.ErrorCode;
import com.bootcamp.demo.bc_sb_jph_ex2.repository.UserRepository;
import com.bootcamp.demo.bc_sb_jph_ex2.service.UserService;
import com.bootcamp.demo.bc_sb_jph_ex2.util.BusinessException;

@Service
public class UserServiceImpl implements UserService {
  @Autowired
  private UserRepository userRepository;

  @Override
  public List<UserEntity> createAll(List<UserEntity> userEntity) {
    return userRepository.saveAll(userEntity);
  }

  @Override
  public List<UserEntity> getAll() {
    return userRepository.findAll();
  }

  @Override
  public UserEntity getById(Long id) {
    return this.userRepository.findById(id)
        .orElseThrow(() -> BusinessException.of(ErrorCode.USER_NOT_FOUND_EX));
  }

  @Override
  public UserEntity updateById(Long id, UserEntity userEntity) {
    UserEntity updateEntity = this.userRepository.findById(id)
        .orElseThrow(() -> BusinessException.of(ErrorCode.USER_NOT_FOUND_EX));
    updateEntity.setName(userEntity.getName());
    updateEntity.setUsername(userEntity.getUsername());
    updateEntity.setWebsite(userEntity.getWebsite());
    updateEntity.setPhone(userEntity.getPhone());
    updateEntity.setEmail(userEntity.getEmail());
    return this.userRepository.save(updateEntity);
  }
}
