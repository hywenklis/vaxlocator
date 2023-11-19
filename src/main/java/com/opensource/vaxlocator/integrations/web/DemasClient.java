package com.opensource.vaxlocator.integrations.web;

import com.opensource.vaxlocator.integrations.response.demas.EstablishmentsInfoResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "demasClient", url = "https://apidadosabertos.saude.gov.br")
public interface DemasClient {

  @GetMapping("/cnes/estabelecimentos")
  EstablishmentsInfoResponse getEstablishmentInformation(
      @RequestParam("codigo_tipo_unidade") Integer unityTypeCode,
      @RequestParam("codigo_uf") Integer ufCode,
      @RequestParam("limit") Integer limit,
      @RequestParam("offset") Integer offset
  );
}
