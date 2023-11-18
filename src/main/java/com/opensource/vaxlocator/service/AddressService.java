package com.opensource.vaxlocator.service;

import com.opensource.vaxlocator.domains.dtos.AddressDomainDto;

public interface AddressService {
  AddressDomainDto retrieveAddressBy(String postalCode);
}
