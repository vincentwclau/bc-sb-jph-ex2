package com.bootcamp.demo.bc_sb_jph_ex2.service;

import java.util.List;
import com.bootcamp.demo.bc_sb_jph_ex2.entity.PostEntity;

public interface PostService {
  List<PostEntity> saveAll(List<PostEntity> postEntity);
}
