package com.bootcamp.demo.bc_sb_jph_ex2.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bootcamp.demo.bc_sb_jph_ex2.entity.PostEntity;
import com.bootcamp.demo.bc_sb_jph_ex2.repository.PostRepository;
import com.bootcamp.demo.bc_sb_jph_ex2.service.PostService;

@Service
public class PostServiceImpl implements PostService {
  @Autowired
  private PostRepository postRepository;

  @Override
  public List<PostEntity> saveAll(List<PostEntity> postEntity) {
    return postRepository.saveAll(postEntity);
  }
}
