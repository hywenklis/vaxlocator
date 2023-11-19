package com.opensource.vaxlocator.service;

import com.opensource.vaxlocator.domains.dtos.EstablishmentsInfoDomainDto;

public interface VaccinationPointsService {
  EstablishmentsInfoDomainDto retrieveVaccinationPointsDetails(final String postalCode);
}
