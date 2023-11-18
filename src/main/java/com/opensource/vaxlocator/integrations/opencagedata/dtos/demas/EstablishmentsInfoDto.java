package com.opensource.vaxlocator.integrations.opencagedata.dtos.demas;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import java.util.List;

@JsonInclude(Include.NON_NULL)
public record EstablishmentsInfoDto(List<EstablishmentDto> establishments) { }
