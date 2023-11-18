package com.opensource.vaxlocator.web.controllers.admin;

import com.opensource.vaxlocator.integrations.opencagedata.dtos.demas.EstablishmentsInfoDto;
import com.opensource.vaxlocator.integrations.opencagedata.dtos.opencagedata.OpenCageDataDto;
import com.opensource.vaxlocator.integrations.opencagedata.service.DemasService;
import com.opensource.vaxlocator.integrations.opencagedata.service.OpenCageDataService;
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

  @GetMapping("/open/cage/data")
  public ResponseEntity<OpenCageDataDto> findAddressInformation(
      @RequestParam() String apiKey,
      @RequestParam("postalCode") String query
  ) {
    return ResponseEntity.status(HttpStatus.OK)
        .body(openCageDataService.getAddressInformation(apiKey, query));
  }

  @GetMapping("/demas/gov")
  public ResponseEntity<EstablishmentsInfoDto> findEstablishmentsInformation(
      @RequestParam Integer unityTypeCode,
      @RequestParam Integer ufCode,
      @RequestParam Integer limit,
      @RequestParam Integer offset
  ) {
    return ResponseEntity.status(HttpStatus.OK)
        .body(demasService.getEstablishments(unityTypeCode, ufCode, limit, offset));
  }
}
