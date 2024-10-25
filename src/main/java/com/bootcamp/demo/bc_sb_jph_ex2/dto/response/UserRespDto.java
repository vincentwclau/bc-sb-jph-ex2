package com.bootcamp.demo.bc_sb_jph_ex2.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class UserRespDto {
  private Long id;
  private String name;
  private String username;
  private String email;
  private String phone;
  private String website;
  @JsonProperty("addressSuite")
  private String suite;
  @JsonProperty("addressStreet")
  private String street;
  @JsonProperty("addressCity")
  private String city;
  @JsonProperty("addressZipcode")
  private String zipcode;
  @JsonProperty("addressLatitude")
  private String latitude;
  @JsonProperty("addressLongitude")
  private String longitude;
  private String companyName;
  private String companyBS;
  private String companyCatchPhrase;
}
