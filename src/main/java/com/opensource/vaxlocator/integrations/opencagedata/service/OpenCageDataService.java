package com.opensource.vaxlocator.integrations.opencagedata.service;

import com.opensource.vaxlocator.integrations.opencagedata.dtos.opencagedata.OpenCageDataDto;
import com.opensource.vaxlocator.integrations.opencagedata.mappers.OpenCageDataMapper;
import com.opensource.vaxlocator.integrations.opencagedata.response.opencagedata.OpenCageDataResponse;
import com.opensource.vaxlocator.integrations.opencagedata.web.OpenCageDataClient;
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
