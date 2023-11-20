package com.opensource.vaxlocator.service.impls;

import com.opensource.vaxlocator.domains.dtos.AddressDomainDto;
import com.opensource.vaxlocator.domains.mappers.AddressMapper;
import com.opensource.vaxlocator.integrations.service.OpenCageDataService;
import com.opensource.vaxlocator.service.AddressRepositoryService;
import com.opensource.vaxlocator.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService {

  private final OpenCageDataService openCageDataService;
  private final AddressMapper addressMapper;
  private final AddressRepositoryService addressRepositoryService;

  @Override
  public AddressDomainDto retrieveAddressBy(final String postalCode) {

    final var existingAddress = addressRepositoryService.findByPostalCode(postalCode);

    return existingAddress.orElseGet(() -> {

      final var addressInformation = openCageDataService.getAddressInformation(
          "",
          postalCode
      );

      return addressRepositoryService.save(addressMapper.mapToDto(addressInformation));
    });
  }
}
