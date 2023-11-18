package com.opensource.vaxlocator.integrations.opencagedata.response.opencagedata;

import java.util.List;


public record OpenCageDataResponse (List<ResultResponse> results) {}
