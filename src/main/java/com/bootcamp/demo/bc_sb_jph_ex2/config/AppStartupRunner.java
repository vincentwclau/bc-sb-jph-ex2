package com.bootcamp.demo.bc_sb_jph_ex2.config;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.bootcamp.demo.bc_sb_jph_ex2.entity.AddressEntity;
import com.bootcamp.demo.bc_sb_jph_ex2.entity.CommentEntity;
import com.bootcamp.demo.bc_sb_jph_ex2.entity.CompanyEntity;
import com.bootcamp.demo.bc_sb_jph_ex2.entity.GeoEntity;
import com.bootcamp.demo.bc_sb_jph_ex2.entity.PostEntity;
import com.bootcamp.demo.bc_sb_jph_ex2.entity.UserEntity;
import com.bootcamp.demo.bc_sb_jph_ex2.mapper.JPHMapper;
import com.bootcamp.demo.bc_sb_jph_ex2.model.dto.CommentDTO;
import com.bootcamp.demo.bc_sb_jph_ex2.model.dto.PostDTO;
import com.bootcamp.demo.bc_sb_jph_ex2.model.dto.UserDTO;
import com.bootcamp.demo.bc_sb_jph_ex2.service.JPHService;
import com.bootcamp.demo.bc_sb_jph_ex2.service.UserService;

@Component
public class AppStartupRunner implements CommandLineRunner {
  @Autowired
  private JPHService jphService;

  @Autowired
  private UserService userService;

  @Autowired
  private JPHMapper jphMapper;

  @Override
  public void run(String... args) throws Exception {
    // Get the source data
    List<UserDTO> usersDTO = jphService.getUsers();
    List<PostDTO> postsDTO = jphService.getPosts();
    List<CommentDTO> commentsDTO = jphService.getComments();

    // Convert and construct UserEntity
    List<UserEntity> userEntities = usersDTO.stream().map(uDto -> {
      UserEntity userEntity = this.jphMapper.map(uDto);

      AddressEntity addressEntity = this.jphMapper.map(uDto.getAddress());
      
      GeoEntity geoEntity = this.jphMapper.map(uDto.getAddress().getGeo());
      geoEntity.setAddress(addressEntity);

      addressEntity.setGeo(geoEntity);
      addressEntity.setUser(userEntity);

      CompanyEntity companyEntity = this.jphMapper.map(uDto.getCompany());
      companyEntity.setUser(userEntity);

      List<PostEntity> postEntities = postsDTO.stream() //
          .filter(pDto -> pDto.getUserId().equals(uDto.getId())) //
          .map(pDto -> {
            PostEntity postEntity = this.jphMapper.map(pDto);

            List<CommentEntity> commentEntities = commentsDTO.stream() //
                .filter(cDto -> cDto.getPostId().equals(pDto.getId())) //
                .map(cDto -> {
                  CommentEntity commentEntity = this.jphMapper.map(cDto);
                  commentEntity.setPost(postEntity);
                  return commentEntity;
                }).collect(Collectors.toList());

            postEntity.setComments(commentEntities);
            postEntity.setUser(userEntity);
            return postEntity;
          }) //
          .collect(Collectors.toList());
      
      userEntity.setAddress(addressEntity);
      userEntity.setCompany(companyEntity);
      userEntity.setPosts(postEntities);
      return userEntity;
    }).collect(Collectors.toList());

    // Save all data to all Users, Posts, Comments, Addresses, Companies, Geos
    userService.createAll(userEntities);
  }
}
