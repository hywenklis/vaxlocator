package com.opensource.vaxlocator.domains.mappers;

import com.opensource.vaxlocator.domains.dtos.EstablishmentDomainDto;
import com.opensource.vaxlocator.domains.dtos.EstablishmentsInfoDomainDto;
import com.opensource.vaxlocator.domains.entities.EstablishmentEntity;
import com.opensource.vaxlocator.integrations.opencagedata.dtos.demas.EstablishmentDto;
import com.opensource.vaxlocator.integrations.opencagedata.dtos.demas.EstablishmentsInfoDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EstablishmentMapper {

  EstablishmentDomainDto mapEntityToDto(EstablishmentEntity establishmentEntity);

  @Mapping(target = "id", ignore = true)
  EstablishmentEntity mapDtoToEntity(EstablishmentDomainDto establishmentDomainDto);

  List<EstablishmentDomainDto> mapEntitiesToDtos(List<EstablishmentEntity> establishmentEntities);

  EstablishmentsInfoDomainDto mapDtoToDomain(EstablishmentsInfoDto establishmentsInfoDto);

  EstablishmentDomainDto mapDtoToDomain(EstablishmentDto establishmentDto);

  List<EstablishmentDomainDto> mapDtosToDomains(List<EstablishmentDto> establishmentDtos);

  List<EstablishmentEntity> mapDtosToEntities(List<EstablishmentDomainDto> establishmentDomainDtos);
}
