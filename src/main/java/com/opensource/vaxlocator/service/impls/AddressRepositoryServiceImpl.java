package com.opensource.vaxlocator.service.impls;

import com.opensource.vaxlocator.domains.dtos.AddressDomainDto;
import com.opensource.vaxlocator.domains.entities.AddressEntity;
import com.opensource.vaxlocator.domains.mappers.AddressMapper;
import com.opensource.vaxlocator.domains.repositories.AddressRepository;
import com.opensource.vaxlocator.service.AddressRepositoryService;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class AddressRepositoryServiceImpl implements AddressRepositoryService {

  private final AddressMapper addressMapper;
  private final AddressRepository addressRepository;

  @Override
  public AddressDomainDto save(final AddressDomainDto addressDto) {
    final AddressEntity addressEntity = addressMapper.mapToEntity(addressDto);
    final AddressEntity savedAddress = addressRepository.save(addressEntity);

    log.info("New address saved in the database. addressDto={}", addressDto);
    return addressMapper.mapToDto(savedAddress);
  }

  @Override
  public Optional<AddressDomainDto> findByPostalCode(final String postalCode) {
    final Optional<AddressEntity> existingAddress = addressRepository.findByPostalCode(postalCode);

    if (existingAddress.isPresent()) {
      log.info("Address found in the database. Retrieving from database. postalCode={}",
          postalCode
      );

      return Optional.of(addressMapper.mapToDto(existingAddress.get()));
    } else {
      log.info(
          "Address not found in the database. "
              + "Retrieving from API and saving to database. postalCode={}",
          postalCode
      );

      return Optional.empty();
    }
  }
}
