package com.opensource.vaxlocator.service.impls;

import com.opensource.vaxlocator.domains.dtos.AddressDomainDto;
import com.opensource.vaxlocator.domains.dtos.CoordinateDomainDto;
import com.opensource.vaxlocator.domains.mappers.CoordinateMapper;
import com.opensource.vaxlocator.service.AddressService;
import com.opensource.vaxlocator.service.CoordinateService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CoordinateServiceImpl implements CoordinateService {

  private final AddressService addressService;
  private final CoordinateMapper coordinateMapper;

  @Override
  public CoordinateDomainDto retrieveCurrentCoordinate(final String postalCode) {
    AddressDomainDto addressDto = addressService.retrieveAddressBy(postalCode);
    return coordinateMapper.mapToDto(addressDto);
  }

  @Override
  public Boolean isValid(final Double latitude, final Double longitude) {
    return latitude != null && longitude != null;
  }
}
