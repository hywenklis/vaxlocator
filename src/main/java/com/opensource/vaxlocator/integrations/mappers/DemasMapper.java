package com.opensource.vaxlocator.integrations.mappers;

import com.opensource.vaxlocator.integrations.dtos.demas.EstablishmentDto;
import com.opensource.vaxlocator.integrations.dtos.demas.EstablishmentsInfoDto;
import com.opensource.vaxlocator.integrations.response.demas.EstablishmentsInfoResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DemasMapper {

  EstablishmentsInfoDto mapToDto(EstablishmentsInfoResponse response);

  EstablishmentDto mapToDto(EstablishmentDto response);
}
