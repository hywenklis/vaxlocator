package com.opensource.vaxlocator.service;

import com.opensource.vaxlocator.domains.dtos.AddressDomainDto;
import java.util.Optional;

public interface AddressRepositoryService {

  AddressDomainDto save(final AddressDomainDto addressDto);
  Optional<AddressDomainDto> findByPostalCode(final String postalCode);
}
