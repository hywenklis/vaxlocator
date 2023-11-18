package com.opensource.vaxlocator.domains.mappers;

import com.opensource.vaxlocator.domains.dtos.EstablishmentDto;
import com.opensource.vaxlocator.domains.entities.EstablishmentEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface EstablishmentMapper {

  EstablishmentDto mapToDto(EstablishmentEntity establishmentEntity);

  @Mapping(target = "id", ignore = true)
  EstablishmentEntity mapToEntity(EstablishmentDto establishmentDto);
}
