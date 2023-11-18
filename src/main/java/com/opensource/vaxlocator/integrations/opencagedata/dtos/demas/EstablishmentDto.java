package com.opensource.vaxlocator.integrations.opencagedata.dtos.demas;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public record EstablishmentDto(Integer establishmentCode,
                               String cnpj,
                               String companyName,
                               String fantasyName,
                               String natureOrganizationName,
                               String managementType,
                               String hierarchyLevelDescription,
                               String administrativeSphereDescription,
                               Integer unityTypeCode,
                               String cep,
                               String address,
                               String number,
                               String district,
                               String phoneNumber,
                               Number latitude,
                               Number longitude,
                               String email,
                               String numberCnpj,
                               String serviceTurnIdentifierCode,
                               String turnServiceDescription,
                               String establishmentProvidesOutpatientCare,
                               String healthEstablishmentCode,
                               Integer uf,
                               Integer cityCode,
                               String descriptionLegalNatureEstablishment,
                               String establishmentDisablingReasonCode,
                               Integer establishmentHasSurgicalCenter,
                               Integer establishmentHasAnObstetricCenter,
                               Integer establishmentHasNeonatalCenter,
                               Integer establishmentHasHospitalCare,
                               Integer establishmentHasSupportService,
                               Integer establishmentHasOutpatientCare,
                               Integer activityCodeTeachingUnit,
                               Integer natureOrganizationUnityCode,
                               Integer unitHierarchyLevelCode,
                               Integer administrativeSphereUnitCode
) {

}
