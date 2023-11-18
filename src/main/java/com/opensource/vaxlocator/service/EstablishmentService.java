package com.opensource.vaxlocator.service;

import com.opensource.vaxlocator.domains.dtos.EstablishmentDto;
import java.util.List;

public interface EstablishmentService {

  List<EstablishmentDto> retrieveEstablishmentsBy(final Double latitude, final Double longitude);
}
