package com.opensource.vaxlocator.service;

import com.opensource.vaxlocator.domains.dtos.AddressDto;

public interface AddressService {
  AddressDto retrieveAddressBy(String postalCode);
}
