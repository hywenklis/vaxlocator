package com.opensource.vaxlocator.integrations.opencagedata.response;

import java.util.List;


public record OpenCageDataResponse (List<ResultResponse> results) {}
