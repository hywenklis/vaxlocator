package com.opensource.vaxlocator.integrations.opencagedata.response.demas;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EstablishmentResponse {

  private @JsonProperty("codigo_cnes") Integer establishmentCode;
  private @JsonProperty("numero_cnpj_entidade") String cnpj;
  private @JsonProperty("nome_razao_social") String companyName;
  private @JsonProperty("nome_fantasia") String fantasyName;
  private @JsonProperty("natureza_organizacao_entidade") String natureOrganizationName;
  private @JsonProperty("tipo_gestao") String managementType;
  private @JsonProperty("descricao_nivel_hierarquia") String hierarchyLevelDescription;
  private @JsonProperty("descricao_esfera_administrativa") String administrativeSphereDescription;
  private @JsonProperty("codigo_tipo_unidade") Integer unityTypeCode;
  private @JsonProperty("codigo_cep_estabelecimento") String cep;
  private @JsonProperty("endereco_estabelecimento") String address;
  private @JsonProperty("numero_estabelecimento") String number;
  private @JsonProperty("bairro_estabelecimento") String district;
  private @JsonProperty("numero_telefone_estabelecimento") String phoneNumber;
  private @JsonProperty("latitude_estabelecimento_decimo_grau") Number latitude;
  private @JsonProperty("longitude_estabelecimento_decimo_grau") Number longitude;
  private @JsonProperty("endereco_email_estabelecimento") String email;
  private @JsonProperty("numero_cnpj") String numberCnpj;
  private @JsonProperty("codigo_identificador_turno_atendimento") String serviceTurnIdentifierCode;
  private @JsonProperty("descricao_turno_atendimento") String turnServiceDescription;
  private @JsonProperty("estabelecimento_faz_atendimento_ambulatorial_sus") String establishmentProvidesOutpatientCare;
  private @JsonProperty("codigo_estabelecimento_saude") String healthEstablishmentCode;
  private @JsonProperty("uf") Integer uf;
  private @JsonProperty("codigo_municipio") Integer cityCode;
  private @JsonProperty("descricao_natureza_juridica_estabelecimento") String descriptionLegalNatureEstablishment;
  private @JsonProperty("codigo_motivo_desabilitacao_estabelecimento") String establishmentDisablingReasonCode;
  private @JsonProperty("estabelecimento_possui_centro_cirurgico") Integer establishmentHasSurgicalCenter;
  private @JsonProperty("estabelecimento_possui_centro_obstetrico") Integer establishmentHasAnObstetricCenter;
  private @JsonProperty("estabelecimento_possui_centro_neonatal") Integer establishmentHasNeonatalCenter;
  private @JsonProperty("estabelecimento_possui_atendimento_hospitalar") Integer establishmentHasHospitalCare;
  private @JsonProperty("estabelecimento_possui_servico_apoio") Integer establishmentHasSupportService;
  private @JsonProperty("estabelecimento_possui_atendimento_ambulatorial") Integer establishmentHasOutpatientCare;
  private @JsonProperty("codigo_atividade_ensino_unidade") Integer activityCodeTeachingUnit;
  private @JsonProperty("codigo_natureza_organizacao_unidade") Integer natureOrganizationUnityCode;
  private @JsonProperty("codigo_nivel_hierarquia_unidade") Integer unitHierarchyLevelCode;
  private @JsonProperty("codigo_esfera_administrativa_unidade") Integer administrativeSphereUnitCode;
}
