package com.bootcamp.demo.bc_sb_jph_ex2.service;

import java.util.List;
import com.bootcamp.demo.bc_sb_jph_ex2.entity.CommentEntity;

public interface CommentService {
  List<CommentEntity> saveAll(List<CommentEntity> commentEntity);
}
