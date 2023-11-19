package com.opensource.vaxlocator.service.impls;

import com.opensource.vaxlocator.domains.dtos.EstablishmentDomainDto;
import com.opensource.vaxlocator.domains.entities.EstablishmentEntity;
import com.opensource.vaxlocator.domains.mappers.EstablishmentMapper;
import com.opensource.vaxlocator.domains.repositories.EstablishmentRepository;
import com.opensource.vaxlocator.integrations.dtos.demas.EstablishmentsInfoDto;
import com.opensource.vaxlocator.integrations.service.DemasService;
import com.opensource.vaxlocator.service.EstablishmentService;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
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
  public List<EstablishmentDomainDto> retrieveEstablishments() {

    List<EstablishmentEntity> existingEstablishments = establishmentRepository.findAll();

    if (!existingEstablishments.isEmpty()) {
      log.info("Establishments found in the database. Retrieving from database.");
      return establishmentMapper.mapEntitiesToDtos(existingEstablishments);
    } else {
      log.info(
          "Establishments not found in the database. Retrieving from API and saving to database.");
      return retrieveAndSaveEstablishments();
    }
  }

  private List<EstablishmentDomainDto> retrieveAndSaveEstablishments() {
    int unityTypeCode = 1;
    int ufCode = 27;
    int offset = 0;
    int limit = 20;

    List<EstablishmentDomainDto> allEstablishments = new ArrayList<>();

    while (true) {
      EstablishmentsInfoDto establishmentsInfo = demasService.getEstablishments(unityTypeCode,
          ufCode, limit, offset);

      if (establishmentsInfo.establishments().isEmpty()) {
        break;
      }

      List<EstablishmentDomainDto> establishmentDomainDtos = establishmentMapper.mapDtosToDomains(
          establishmentsInfo.establishments());

      establishmentDomainDtos = removeDuplicates(establishmentDomainDtos);

      List<EstablishmentEntity> establishmentEntities = establishmentMapper.mapDtosToEntities(
          establishmentDomainDtos);

      List<EstablishmentEntity> savedAllEstablishment = establishmentRepository.saveAll(
          establishmentEntities);

      allEstablishments.addAll(establishmentMapper.mapEntitiesToDtos(savedAllEstablishment));
      offset += limit;
    }

    return allEstablishments;
  }

  private List<EstablishmentDomainDto> removeDuplicates(List<EstablishmentDomainDto> establishments) {
    Set<String> uniquePostalCodes = new HashSet<>();
    List<EstablishmentDomainDto> result = new ArrayList<>();

    establishments.forEach(establishment -> {
      if (uniquePostalCodes.add(establishment.cep())) {
        result.add(establishment);
      }
    });

    return result;
  }
}
