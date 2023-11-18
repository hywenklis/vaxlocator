package com.opensource.vaxlocator.domains.mappers;

import com.opensource.vaxlocator.domains.dtos.AddressDomainDto;
import com.opensource.vaxlocator.domains.entities.AddressEntity;
import com.opensource.vaxlocator.integrations.opencagedata.dtos.opencagedata.OpenCageDataDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AddressMapper {

  AddressDomainDto mapToDto(AddressEntity addressEntity);

  @Mapping(target = "postalCode", expression = "java(openCageDataDto.results().get(0).components().postcode())")
  @Mapping(target = "city", expression = "java(openCageDataDto.results().get(0).components().city())")
  @Mapping(target = "municipality", expression = "java(openCageDataDto.results().get(0).components().municipality())")
  @Mapping(target = "state", expression = "java(openCageDataDto.results().get(0).components().state())")
  @Mapping(target = "region", expression = "java(openCageDataDto.results().get(0).components().region())")
  @Mapping(target = "suburb", expression = "java(openCageDataDto.results().get(0).components().suburb())")
  @Mapping(target = "lat", expression = "java(openCageDataDto.results().get(0).geometry().lat())")
  @Mapping(target = "lng", expression = "java(openCageDataDto.results().get(0).geometry().lng())")
  AddressDomainDto mapToDto(OpenCageDataDto openCageDataDto);

  @Mapping(target = "id", ignore = true)
  AddressEntity mapToEntity(AddressDomainDto addressDto);
}
