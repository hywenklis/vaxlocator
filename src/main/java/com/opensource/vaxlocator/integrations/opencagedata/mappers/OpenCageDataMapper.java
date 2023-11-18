package com.opensource.vaxlocator.integrations.opencagedata.mappers;

import com.opensource.vaxlocator.integrations.opencagedata.dtos.opencagedata.ComponentsDto;
import com.opensource.vaxlocator.integrations.opencagedata.dtos.opencagedata.GeometryDto;
import com.opensource.vaxlocator.integrations.opencagedata.dtos.opencagedata.OpenCageDataDto;
import com.opensource.vaxlocator.integrations.opencagedata.dtos.opencagedata.ResultDto;
import com.opensource.vaxlocator.integrations.opencagedata.response.opencagedata.ComponentsResponse;
import com.opensource.vaxlocator.integrations.opencagedata.response.opencagedata.GeometryResponse;
import com.opensource.vaxlocator.integrations.opencagedata.response.opencagedata.OpenCageDataResponse;
import com.opensource.vaxlocator.integrations.opencagedata.response.opencagedata.ResultResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OpenCageDataMapper {

  OpenCageDataDto mapToDto(OpenCageDataResponse response);

  ResultDto mapToDto(ResultResponse response);

  ComponentsDto mapToDto(ComponentsResponse response);

  GeometryDto mapToDto(GeometryResponse response);
}
