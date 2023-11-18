package com.opensource.vaxlocator.web.controllers.admin;

import com.opensource.vaxlocator.domains.dtos.AddressDto;
import com.opensource.vaxlocator.integrations.opencagedata.dtos.demas.EstablishmentsInfoDto;
import com.opensource.vaxlocator.integrations.opencagedata.dtos.opencagedata.OpenCageDataDto;
import com.opensource.vaxlocator.integrations.opencagedata.service.DemasService;
import com.opensource.vaxlocator.integrations.opencagedata.service.OpenCageDataService;
import com.opensource.vaxlocator.service.AddressService;
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
@RequestMapping("/v1/admin/info")
@RequiredArgsConstructor
@Tag(name = "Admin", description = "Endpoints related to updating information")
public class AdminController {

  private final OpenCageDataService openCageDataService;
  private final DemasService demasService;

  private final AddressService addressService;

  @GetMapping("/open/cage/data")
  @Operation(
      summary = "Find address information",
      description = "Retrieves address information using the OpenCageData API: <a href='https://opencagedata.com/' target='_blank'>https://opencagedata.com/</a>"
  )
  public ResponseEntity<OpenCageDataDto> findAddressInformation(
      @Parameter(description = "API key for authentication", required = true)
      @RequestParam() String apiKey,

      @Parameter(description = "Postal code for address lookup", required = true)
      @RequestParam("postalCode") String query
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
      @RequestParam Integer unityTypeCode,

      @Parameter(description = "Code representing the state", required = true)
      @RequestParam Integer ufCode,

      @Parameter(description = "Maximum number of results to retrieve = 20", required = true)
      @RequestParam Integer limit,

      @Parameter(description = "Offset for paginating through results", required = true)
      @RequestParam Integer offset
  ) {
    return ResponseEntity.status(HttpStatus.OK)
        .body(demasService.getEstablishments(unityTypeCode, ufCode, limit, offset));
  }

  @GetMapping("/address")
  @Operation(
      summary = "Find address information",
      description = "Retrieves address information"
  )
  public ResponseEntity<AddressDto> findAddress(
      @Parameter(description = "Postal code for address lookup", required = true)
      @RequestParam String postalCode
  ) {
    return ResponseEntity.status(HttpStatus.OK)
        .body(addressService.retrieveAddressBy(postalCode));
  }
}
