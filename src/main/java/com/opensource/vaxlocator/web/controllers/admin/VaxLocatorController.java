package com.opensource.vaxlocator.web.controllers.admin;

import com.opensource.vaxlocator.domains.dtos.EstablishmentsInfoDomainDto;
import com.opensource.vaxlocator.service.VaccinationPointsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/vax/locator")
@RequiredArgsConstructor
@Tag(name = "Locator", description = "Endpoint related to vaccination points")
public class VaxLocatorController {

  private final VaccinationPointsService vaccinationPoints;

  @GetMapping("/details")
  @Operation(
      summary = "Find vaccination points",
      description = "retrieves information from vaccination establishments"
  )
  public ResponseEntity<EstablishmentsInfoDomainDto> findAddressInformation(
      @Parameter(description = "Postal code for vaccination points lookup (format: 00000-000)", required = true)
      @RequestParam final String postalCode
  ) {
    return ResponseEntity.status(HttpStatus.OK)
        .body(vaccinationPoints.retrieveVaccinationPointsDetails(postalCode));
  }
}
