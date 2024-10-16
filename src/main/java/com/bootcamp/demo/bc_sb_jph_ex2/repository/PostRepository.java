package com.bootcamp.demo.bc_sb_jph_ex2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.bootcamp.demo.bc_sb_jph_ex2.entity.PostEntity;

@Repository
public interface PostRepository extends JpaRepository<PostEntity, Long> {
  
}