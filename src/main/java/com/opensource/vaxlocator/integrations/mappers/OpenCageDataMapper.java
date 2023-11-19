package com.opensource.vaxlocator.integrations.mappers;

import com.opensource.vaxlocator.integrations.dtos.opencagedata.ComponentsDto;
import com.opensource.vaxlocator.integrations.dtos.opencagedata.GeometryDto;
import com.opensource.vaxlocator.integrations.dtos.opencagedata.OpenCageDataDto;
import com.opensource.vaxlocator.integrations.dtos.opencagedata.ResultDto;
import com.opensource.vaxlocator.integrations.response.opencagedata.ComponentsResponse;
import com.opensource.vaxlocator.integrations.response.opencagedata.GeometryResponse;
import com.opensource.vaxlocator.integrations.response.opencagedata.OpenCageDataResponse;
import com.opensource.vaxlocator.integrations.response.opencagedata.ResultResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OpenCageDataMapper {

  OpenCageDataDto mapToDto(OpenCageDataResponse response);

  ResultDto mapToDto(ResultResponse response);

  ComponentsDto mapToDto(ComponentsResponse response);

  GeometryDto mapToDto(GeometryResponse response);
}
