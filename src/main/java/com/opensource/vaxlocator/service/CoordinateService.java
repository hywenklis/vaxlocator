package com.opensource.vaxlocator.service;

import com.opensource.vaxlocator.domains.dtos.CoordinateDomainDto;

public interface CoordinateService {

  CoordinateDomainDto retrieveCurrentCoordinate(final String postalCode);
  Boolean isValid(Double latitude, Double longitude);
}
