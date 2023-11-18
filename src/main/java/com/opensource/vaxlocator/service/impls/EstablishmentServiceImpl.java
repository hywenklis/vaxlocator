package com.opensource.vaxlocator.service.impls;

import com.opensource.vaxlocator.domains.dtos.EstablishmentDto;
import com.opensource.vaxlocator.service.EstablishmentService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class EstablishmentServiceImpl implements EstablishmentService {

  @Override
  public List<EstablishmentDto> retrieveEstablishmentsBy(Double latitude, Double longitude) {
    return null;
  }
}
