package com.opensource.vaxlocator.service.impls;

import com.opensource.vaxlocator.domains.dtos.AddressDomainDto;
import com.opensource.vaxlocator.domains.dtos.CoordinateDomainDto;
import com.opensource.vaxlocator.domains.dtos.EstablishmentDomainDto;
import com.opensource.vaxlocator.domains.dtos.EstablishmentsInfoDomainDto;
import com.opensource.vaxlocator.domains.mappers.CoordinateMapper;
import com.opensource.vaxlocator.service.AddressService;
import com.opensource.vaxlocator.service.EstablishmentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class VaccinationPointsServiceImpl implements
    com.opensource.vaxlocator.service.VaccinationPointsService {

  private final AddressService addressService;
  private final EstablishmentService establishmentService;
  private final CoordinateMapper coordinateMapper;

  @Override
  public EstablishmentsInfoDomainDto retrieveVaccinationPointsDetails(final String postalCode) {
    CoordinateDomainDto coordinateDto = retrieveCurrentCoordinate(postalCode);
    double currentLatitude = coordinateDto.latitude();
    double currentLongitude = coordinateDto.longitude();
    double radius = 10;

    List<EstablishmentDomainDto> establishmentsInRadius = establishmentService.retrieveEstablishments()
        .stream()
        .filter(coordinate ->
            isWithinRadius(currentLatitude, currentLongitude, coordinate.latitude(),
                coordinate.longitude(), radius))
        .collect(Collectors.toList());

    return new EstablishmentsInfoDomainDto(establishmentsInRadius);
  }

  private CoordinateDomainDto retrieveCurrentCoordinate(final String postalCode) {
    AddressDomainDto addressDto = addressService.retrieveAddressBy(postalCode);
    return coordinateMapper.mapToDto(addressDto);
  }

  private boolean isWithinRadius(double currentLatitude, double currentLongitude, double latitude,
      double longitude, double radius) {
    return calculateDistance(currentLatitude, currentLongitude, latitude, longitude) <= radius;
  }

  private double calculateDistance(double lat1, double lon1, double lat2, double lon2) {
    double earthRadius = 6371;
    double dLat = Math.toRadians(lat2 - lat1);
    double dLon = Math.toRadians(lon2 - lon1);
    double a = Math.sin(dLat / 2) * Math.sin(dLat / 2) +
        Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) *
            Math.sin(dLon / 2) * Math.sin(dLon / 2);
    double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
    return earthRadius * c;
  }
}
