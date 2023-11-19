package com.opensource.vaxlocator.domains.mappers;

import com.opensource.vaxlocator.domains.dtos.AddressDomainDto;
import com.opensource.vaxlocator.domains.dtos.CoordinateDomainDto;
import com.opensource.vaxlocator.domains.dtos.EstablishmentDomainDto;
import com.opensource.vaxlocator.domains.entities.AddressEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CoordinateMapper {

  @Mapping(target = "longitude", source = "address.lng")
  @Mapping(target = "latitude", source = "address.lat")
  CoordinateDomainDto mapToDto(AddressDomainDto address);

  CoordinateDomainDto mapToDto(EstablishmentDomainDto establishmentDomainDto);
}
