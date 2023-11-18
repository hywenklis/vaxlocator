package com.opensource.vaxlocator.integrations.opencagedata.response.demas;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EstablishmentsInfoResponse {
  private @JsonProperty("estabelecimentos") List<EstablishmentResponse> establishments;
}
