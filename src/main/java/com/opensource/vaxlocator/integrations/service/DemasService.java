package com.opensource.vaxlocator.integrations.service;

import com.opensource.vaxlocator.integrations.mappers.DemasMapper;
import com.opensource.vaxlocator.integrations.dtos.demas.EstablishmentsInfoDto;
import com.opensource.vaxlocator.integrations.response.demas.EstablishmentsInfoResponse;
import com.opensource.vaxlocator.integrations.web.DemasClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class DemasService {

  private final DemasClient demasClient;
  private final DemasMapper demasMapper;

  public EstablishmentsInfoDto getEstablishments(
      final Integer unityTypeCode,
      final Integer ufCode,
      final Integer limit,
      final Integer offset
  ) {
    log.info("Fetching establishment information: unityTypeCode={} ufCode={} limit={} offset={}",
        unityTypeCode, ufCode, limit, offset);

    EstablishmentsInfoResponse establishments = demasClient.getEstablishmentInformation(
        unityTypeCode,
        ufCode,
        limit,
        offset
    );

    EstablishmentsInfoDto result = demasMapper.mapToDto(establishments);

    log.info("Establishments information retrieved successfully");
    return result;
  }
}
