package com.bootcamp.demo.bc_sb_jph_ex2.service;

import java.util.List;
import com.bootcamp.demo.bc_sb_jph_ex2.model.dto.CommentDTO;
import com.bootcamp.demo.bc_sb_jph_ex2.model.dto.PostDTO;
import com.bootcamp.demo.bc_sb_jph_ex2.model.dto.UserDTO;

public interface JPHService {
  /**
   * GET all Users: https://jsonplaceholder.typicode.com/users
   * 
   * @return
   */
  List<UserDTO> getUsers();

  /**
   * GET all Posts: https://jsonplaceholder.typicode.com/posts
   * 
   * @return
   */
  List<PostDTO> getPosts();

  /**
   * GET all Comments: https://jsonplaceholder.typicode.com/comments
   * 
   * @return
   */
  List<CommentDTO> getComments();
}
