package com.bootcamp.demo.bc_sb_jph_ex2.mapper;

import org.springframework.stereotype.Component;
import com.bootcamp.demo.bc_sb_jph_ex2.dto.request.UserReqDto;
import com.bootcamp.demo.bc_sb_jph_ex2.dto.response.UserRespDto;
import com.bootcamp.demo.bc_sb_jph_ex2.entity.AddressEntity;
import com.bootcamp.demo.bc_sb_jph_ex2.entity.CompanyEntity;
import com.bootcamp.demo.bc_sb_jph_ex2.entity.GeoEntity;
import com.bootcamp.demo.bc_sb_jph_ex2.entity.UserEntity;

@Component
public class UserMapper {
  public UserEntity map(UserReqDto reqDto) {
    GeoEntity geo = GeoEntity.builder() //
        .lat(reqDto.getLatitude()) //
        .lng(reqDto.getLongitude()) //
        .build();

    AddressEntity address = AddressEntity.builder() //
        .suite(reqDto.getSuite()) //
        .street(reqDto.getStreet()) //
        .city(reqDto.getCity()) //
        .zipcode(reqDto.getZipcode()) //
        .geo(geo) //
        .build();

    CompanyEntity company = CompanyEntity.builder() //
        .name(reqDto.getCompanyName()) //
        .bs(reqDto.getCompanyBS()) //
        .catchPhrase(reqDto.getCompanyCatchPhrase()) //
        .build();

    return UserEntity.builder() //
        .name(reqDto.getName()) //
        .username(reqDto.getUsername()) //
        .email(reqDto.getEmail()) //
        .phone(reqDto.getPhone()) //
        .website(reqDto.getWebsite()) //
        .address(address) //
        .company(company) //
        .build();
  }

  public UserRespDto map(UserEntity entity) {
    return UserRespDto.builder() //
        .id(entity.getId())
        .name(entity.getName()) //
        .username(entity.getUsername()) //
        .email(entity.getEmail()) //
        .phone(entity.getPhone()) //
        .website(entity.getWebsite()) //
        .suite(entity.getAddress().getSuite()) //
        .street(entity.getAddress().getStreet()) //
        .city(entity.getAddress().getCity()) //
        .zipcode(entity.getAddress().getZipcode()) //
        .latitude(entity.getAddress().getGeo().getLat()) //
        .longitude(entity.getAddress().getGeo().getLng()) //
        .companyName(entity.getCompany().getName()) //
        .companyBS(entity.getCompany().getBs()) //
        .companyCatchPhrase(entity.getCompany().getCatchPhrase()) //
        .build();
  }
}
