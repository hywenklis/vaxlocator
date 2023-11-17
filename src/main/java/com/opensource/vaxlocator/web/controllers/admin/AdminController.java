package com.opensource.vaxlocator.web.controllers.admin;

import com.opensource.vaxlocator.integrations.opencagedata.dtos.OpenCageDataDto;
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

  @GetMapping
  public ResponseEntity<OpenCageDataDto> findInformation(
      @RequestParam() String apiKey,
      @RequestParam("postalCode") String query
  ) {
    return ResponseEntity.status(HttpStatus.OK)
        .body(openCageDataService.getAddressInformation(apiKey, query));
  }
}
