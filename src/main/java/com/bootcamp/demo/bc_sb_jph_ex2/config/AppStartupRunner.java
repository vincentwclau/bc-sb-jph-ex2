package com.bootcamp.demo.bc_sb_jph_ex2.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.bootcamp.demo.bc_sb_jph_ex2.repository.CommentRepository;
import com.bootcamp.demo.bc_sb_jph_ex2.repository.PostRepository;
import com.bootcamp.demo.bc_sb_jph_ex2.repository.UserRepository;

@Component
public class AppStartupRunner implements CommandLineRunner {
  @Autowired
  private UserRepository userRepository;

  @Autowired
  private PostRepository postRepository;

  @Autowired
  private CommentRepository commentRepository;
  
  @Override
  public void run(String... args) throws Exception {
    
  }
}
