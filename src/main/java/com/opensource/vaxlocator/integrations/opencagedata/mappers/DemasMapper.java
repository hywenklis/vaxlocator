package com.opensource.vaxlocator.integrations.opencagedata.mappers;

import com.opensource.vaxlocator.integrations.opencagedata.dtos.demas.EstablishmentDto;
import com.opensource.vaxlocator.integrations.opencagedata.dtos.demas.EstablishmentsInfoDto;
import com.opensource.vaxlocator.integrations.opencagedata.response.demas.EstablishmentsInfoResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DemasMapper {

  EstablishmentsInfoDto mapToDto(EstablishmentsInfoResponse response);

  EstablishmentDto mapToDto(EstablishmentDto response);
}
