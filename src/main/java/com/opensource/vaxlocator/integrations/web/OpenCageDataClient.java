package com.opensource.vaxlocator.integrations.web;

import com.opensource.vaxlocator.integrations.response.opencagedata.OpenCageDataResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "openCageDataClient", url = "https://api.opencagedata.com")
public interface OpenCageDataClient {

  @GetMapping("/geocode/v1/json")
  OpenCageDataResponse getAddressInformation(
      @RequestParam("key") String apiKey,
      @RequestParam("q") String query
  );
}
