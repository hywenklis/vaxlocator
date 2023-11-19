package com.opensource.vaxlocator.integrations.service;

import com.opensource.vaxlocator.integrations.dtos.opencagedata.OpenCageDataDto;
import com.opensource.vaxlocator.integrations.mappers.OpenCageDataMapper;
import com.opensource.vaxlocator.integrations.response.opencagedata.OpenCageDataResponse;
import com.opensource.vaxlocator.integrations.web.OpenCageDataClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class OpenCageDataService {

  private final OpenCageDataClient openCageDataClient;
  private final OpenCageDataMapper openCageDataMapper;

  public OpenCageDataDto getAddressInformation(final String apiKey, final String query) {
    log.info("Getting address information for query: {}", query);

    OpenCageDataResponse addressInformation = openCageDataClient.getAddressInformation(
        apiKey,
        query
    );

    OpenCageDataDto result = openCageDataMapper.mapToDto(addressInformation);

    log.info("Address information retrieved successfully: {}", result);
    return result;
  }
}
