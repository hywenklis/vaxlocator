package com.opensource.vaxlocator.service.impls;

import com.opensource.vaxlocator.domains.dtos.CoordinateDomainDto;
import com.opensource.vaxlocator.domains.dtos.EstablishmentDomainDto;
import com.opensource.vaxlocator.domains.dtos.EstablishmentsInfoDomainDto;
import com.opensource.vaxlocator.service.CoordinateService;
import com.opensource.vaxlocator.service.DistanceCalculatorService;
import com.opensource.vaxlocator.service.EstablishmentService;
import com.opensource.vaxlocator.service.VaccinationPointsService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class VaccinationPointsServiceImpl implements VaccinationPointsService {

  private final EstablishmentService establishmentService;
  private final CoordinateService coordinateService;
  private final DistanceCalculatorService distanceCalculatorService;

  @Override
  public EstablishmentsInfoDomainDto retrieveVaccinationPointsDetails(final String postalCode) {
    CoordinateDomainDto coordinateDto = coordinateService.retrieveCurrentCoordinate(postalCode);
    Double currentLatitude = coordinateDto.latitude();
    Double currentLongitude = coordinateDto.longitude();
    double radius = 10;

    List<EstablishmentDomainDto> establishmentsInRadius = establishmentService.retrieveEstablishments()
        .stream()
        .filter(coordinate ->
            isWithinRadius(
                currentLatitude,
                currentLongitude,
                coordinate.latitude(),
                coordinate.longitude(),
                radius)
        ).toList();

    return new EstablishmentsInfoDomainDto(establishmentsInRadius);
  }

  private boolean isWithinRadius(
      Double currentLatitude,
      Double currentLongitude,
      Double latitude,
      Double longitude,
      Double radius
  ) {
    if (Boolean.FALSE.equals(coordinateService.isValid(latitude, longitude))) {
      return false;
    }

    return distanceCalculatorService.calculateDistance(
        currentLatitude,
        currentLongitude,
        latitude,
        longitude
    ) <= radius;
  }
}
