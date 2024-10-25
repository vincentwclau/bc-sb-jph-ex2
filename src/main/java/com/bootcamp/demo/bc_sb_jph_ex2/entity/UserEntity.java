package com.bootcamp.demo.bc_sb_jph_ex2.entity;

import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Users")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String name;
  @Column(name = "user_name")
  private String username;
  private String email;
  private String phone;
  private String website;

  @OneToOne(mappedBy = "user", cascade = CascadeType.ALL,
      fetch = FetchType.LAZY)
  private AddressEntity address;

  @OneToOne(mappedBy = "user", cascade = CascadeType.ALL,
      fetch = FetchType.LAZY)
  private CompanyEntity company;

  @Builder.Default
  @OneToMany(mappedBy = "user", cascade = CascadeType.ALL,
      fetch = FetchType.LAZY)
  private List<PostEntity> posts = new ArrayList<>();
}
