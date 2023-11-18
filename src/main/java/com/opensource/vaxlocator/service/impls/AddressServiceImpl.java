package com.opensource.vaxlocator.service.impls;

import com.opensource.vaxlocator.domains.dtos.AddressDomainDto;
import com.opensource.vaxlocator.domains.entities.AddressEntity;
import com.opensource.vaxlocator.domains.mappers.AddressMapper;
import com.opensource.vaxlocator.domains.repositories.AddressRepository;
import com.opensource.vaxlocator.integrations.opencagedata.service.OpenCageDataService;
import com.opensource.vaxlocator.service.AddressService;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService {

  private final OpenCageDataService openCageDataService;
  private final AddressMapper addressMapper;
  private final AddressRepository addressRepository;

  @Override
  public AddressDomainDto retrieveAddressBy(final String postalCode) {
    final Optional<AddressEntity> existingAddress = addressRepository.findByPostalCode(postalCode);

    if (existingAddress.isPresent()) {
      log.info("Address found in the database. Retrieving from database.");
      return addressMapper.mapToDto(existingAddress.get());
    } else {
      log.info("Address not found in the database. Retrieving from API and saving to database.");
      final var addressInformation = openCageDataService.getAddressInformation("", postalCode);
      final var newAddressDto = addressMapper.mapToDto(addressInformation);
      return save(newAddressDto);
    }
  }

  private AddressDomainDto save(final AddressDomainDto addressDto) {
    final AddressEntity addressEntity = addressMapper.mapToEntity(addressDto);
    final AddressEntity savedAddress = addressRepository.save(addressEntity);
    return addressMapper.mapToDto(savedAddress);
  }
}


