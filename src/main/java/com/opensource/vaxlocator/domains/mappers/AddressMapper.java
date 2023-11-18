package com.opensource.vaxlocator.domains.mappers;

import com.opensource.vaxlocator.domains.dtos.AddressDto;
import com.opensource.vaxlocator.domains.entities.AddressEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AddressMapper {

  AddressDto mapToDto(AddressEntity addressEntity);

  @Mapping(target = "id", ignore = true)
  AddressEntity mapToEntity(AddressDto addressDto);
}
