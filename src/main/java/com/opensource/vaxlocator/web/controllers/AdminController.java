package com.opensource.vaxlocator.web.controllers;

import com.opensource.vaxlocator.domains.dtos.AddressDomainDto;
import com.opensource.vaxlocator.domains.dtos.EstablishmentDomainDto;
import com.opensource.vaxlocator.integrations.dtos.demas.EstablishmentsInfoDto;
import com.opensource.vaxlocator.integrations.dtos.opencagedata.OpenCageDataDto;
import com.opensource.vaxlocator.integrations.service.DemasService;
import com.opensource.vaxlocator.integrations.service.OpenCageDataService;
import com.opensource.vaxlocator.service.AddressService;
import com.opensource.vaxlocator.service.EstablishmentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/admin/info")
@RequiredArgsConstructor
@Tag(name = "Admin", description = "Endpoints related to updating information")
public class AdminController {

  private final OpenCageDataService openCageDataService;
  private final DemasService demasService;

  private final AddressService addressService;
  private final EstablishmentService establishmentService;

  @GetMapping("/open/cage/data")
  @Operation(
      summary = "Find address information",
      description = "Retrieves address information using the OpenCageData API: <a href='https://opencagedata.com/' target='_blank'>https://opencagedata.com/</a>"
  )
  public ResponseEntity<OpenCageDataDto> findAddressInformation(
      @Parameter(description = "API key for authentication", required = true)
      @RequestParam() final String apiKey,

      @Parameter(description = "Postal code for address lookup", required = true)
      @RequestParam("postalCode") final String query
  ) {
    return ResponseEntity.status(HttpStatus.OK)
        .body(openCageDataService.getAddressInformation(apiKey, query));
  }

  @GetMapping("/demas/gov")
  @Operation(
      summary = "Find establishments information",
      description = "Retrieves establishments information using the Demas API: <a href='https://apidadosabertos.saude.gov.br/v1/' target='_blank'>https://apidadosabertos.saude.gov.br/v1/</a>"
  )
  public ResponseEntity<EstablishmentsInfoDto> findEstablishmentsInformation(
      @Parameter(description = "Code representing the type of unity", required = true)
      @RequestParam final Integer unityTypeCode,

      @Parameter(description = "Code representing the state", required = true)
      @RequestParam final Integer ufCode,

      @Parameter(description = "Maximum number of results to retrieve = 20", required = true)
      @RequestParam final Integer limit,

      @Parameter(description = "Offset for paginating through results", required = true)
      @RequestParam final Integer offset
  ) {
    return ResponseEntity.status(HttpStatus.OK)
        .body(demasService.getEstablishments(unityTypeCode, ufCode, limit, offset));
  }

  @GetMapping("/address")
  @Operation(
      summary = "Find address information in database",
      description = "Retrieves address information in database"
  )
  public ResponseEntity<AddressDomainDto> findAddress(
      @Parameter(description = "Example postal code for address lookup (format: 00000-000)", required = true)
      @RequestParam final String postalCode
  ) {
    return ResponseEntity.status(HttpStatus.OK)
        .body(addressService.retrieveAddressBy(postalCode));
  }

  @GetMapping("/establishments")
  @Operation(
      summary = "Find all establishment information in database",
      description = "Retrieves establishment information in database"
  )
  public ResponseEntity<List<EstablishmentDomainDto>> findAllEstablishment() {
    return ResponseEntity.status(HttpStatus.OK)
        .body(establishmentService.retrieveEstablishments());
  }
}
