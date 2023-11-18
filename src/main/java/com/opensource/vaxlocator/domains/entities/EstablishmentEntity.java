package com.opensource.vaxlocator.domains.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "establishment")
public class EstablishmentEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private Integer establishmentCode;
  private String cnpj;
  private String companyName;
  private String fantasyName;
  private String natureOrganizationName;
  private String managementType;
  private String hierarchyLevelDescription;
  private String administrativeSphereDescription;
  private Integer unityTypeCode;
  private String cep;
  private String address;
  private String number;
  private String district;
  private String phoneNumber;
  private Double latitude;
  private Double longitude;
  private String email;
  private String numberCnpj;
  private String serviceTurnIdentifierCode;
  private String turnServiceDescription;
  private String establishmentProvidesOutpatientCare;
  private String healthEstablishmentCode;
  private Integer uf;
  private Integer cityCode;
  private String descriptionLegalNatureEstablishment;
  private String establishmentDisablingReasonCode;
  private Integer establishmentHasSurgicalCenter;
  private Integer establishmentHasAnObstetricCenter;
  private Integer establishmentHasNeonatalCenter;
  private Integer establishmentHasHospitalCare;
  private Integer establishmentHasSupportService;
  private Integer establishmentHasOutpatientCare;
  private Integer activityCodeTeachingUnit;
  private Integer natureOrganizationUnityCode;
  private Integer unitHierarchyLevelCode;
  private Integer administrativeSphereUnitCode;
}
