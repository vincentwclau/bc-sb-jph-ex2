package com.bootcamp.demo.bc_sb_jph_ex2.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bootcamp.demo.bc_sb_jph_ex2.entity.CommentEntity;
import com.bootcamp.demo.bc_sb_jph_ex2.repository.CommentRepository;
import com.bootcamp.demo.bc_sb_jph_ex2.service.CommentService;

@Service
public class CommentServiceImpl implements CommentService {
  @Autowired
  private CommentRepository commentRepository;

  @Override
  public List<CommentEntity> saveAll(List<CommentEntity> commentEntity) {
    return commentRepository.saveAll(commentEntity);
  }
}
