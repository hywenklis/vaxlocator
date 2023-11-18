package com.opensource.vaxlocator.service;

import com.opensource.vaxlocator.domains.dtos.CoordinateDomainDto;
import com.opensource.vaxlocator.domains.dtos.EstablishmentDomainDto;
import java.util.List;

public interface EstablishmentService {

  List<EstablishmentDomainDto> retrieveEstablishmentsBy(final List<CoordinateDomainDto> coordinates);
}
