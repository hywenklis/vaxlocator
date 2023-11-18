package com.opensource.vaxlocator.service.impls;

import com.opensource.vaxlocator.domains.dtos.CoordinateDomainDto;
import com.opensource.vaxlocator.domains.dtos.EstablishmentDomainDto;
import com.opensource.vaxlocator.domains.entities.EstablishmentEntity;
import com.opensource.vaxlocator.domains.mappers.EstablishmentMapper;
import com.opensource.vaxlocator.domains.repositories.EstablishmentRepository;
import com.opensource.vaxlocator.integrations.opencagedata.dtos.demas.EstablishmentsInfoDto;
import com.opensource.vaxlocator.integrations.opencagedata.service.DemasService;
import com.opensource.vaxlocator.service.EstablishmentService;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class EstablishmentServiceImpl implements EstablishmentService {

  private final DemasService demasService;
  private final EstablishmentRepository establishmentRepository;
  private final EstablishmentMapper establishmentMapper;

  @Override
  public List<EstablishmentDomainDto> retrieveEstablishmentsBy(
      final List<CoordinateDomainDto> coordinates
  ) {

    List<EstablishmentDomainDto> allEstablishments = new ArrayList<>();

    for (CoordinateDomainDto coordinate : coordinates) {
      Double latitude = coordinate.latitude();
      Double longitude = coordinate.longitude();

      Optional<List<EstablishmentDomainDto>> existingEstablishments =
          establishmentRepository.findByLatitudeAndLongitude(latitude, longitude);

      if (existingEstablishments.isPresent()) {
        allEstablishments.addAll(existingEstablishments.get());
        log.info("Establishments found in the database. Retrieving from database.");
      } else {
        log.info(
            "Establishments not found in the database. Retrieving from API and saving to database.");
        List<EstablishmentDomainDto> establishments = retrieveAndSaveEstablishments();
        allEstablishments.addAll(establishments);
      }
    }

    return allEstablishments;
  }

  private List<EstablishmentDomainDto> retrieveAndSaveEstablishments() {

    List<EstablishmentDomainDto> allEstablishments = new ArrayList<>();

    Integer unityTypeCode = 1;
    Integer ufCode = 27;
    int offset = 0;
    int limit = 20;

    while (true) {
      EstablishmentsInfoDto establishmentsInfo =
          demasService.getEstablishments(unityTypeCode, ufCode, limit, offset);

      if (establishmentsInfo.establishments().isEmpty()) {
        break;
      }

      List<EstablishmentDomainDto> establishmentDomainDtos =
          establishmentMapper.mapDtosToDomains(establishmentsInfo.establishments());

      List<EstablishmentEntity> establishmentEntities =
          establishmentMapper.mapDtosToEntities(establishmentDomainDtos);

      List<EstablishmentEntity> savedAllEstablishment = establishmentRepository.saveAll(
          establishmentEntities);

      List<EstablishmentDomainDto> convertEstablishmentsInDto = establishmentMapper.mapEntitiesToDtos(
          savedAllEstablishment);

      allEstablishments.addAll(convertEstablishmentsInDto);

      offset += limit;
    }

    return allEstablishments;
  }
}
