package com.opensource.vaxlocator.integrations.opencagedata.mappers;

import com.opensource.vaxlocator.integrations.opencagedata.dtos.ComponentsDto;
import com.opensource.vaxlocator.integrations.opencagedata.dtos.GeometryDto;
import com.opensource.vaxlocator.integrations.opencagedata.dtos.OpenCageDataDto;
import com.opensource.vaxlocator.integrations.opencagedata.dtos.ResultDto;
import com.opensource.vaxlocator.integrations.opencagedata.response.ComponentsResponse;
import com.opensource.vaxlocator.integrations.opencagedata.response.GeometryResponse;
import com.opensource.vaxlocator.integrations.opencagedata.response.OpenCageDataResponse;
import com.opensource.vaxlocator.integrations.opencagedata.response.ResultResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OpenCageDataMapper {

  OpenCageDataDto mapToDto(OpenCageDataResponse response);

  ResultDto mapToDto(ResultResponse response);

  ComponentsDto mapToDto(ComponentsResponse response);

  GeometryDto mapToDto(GeometryResponse response);
}
