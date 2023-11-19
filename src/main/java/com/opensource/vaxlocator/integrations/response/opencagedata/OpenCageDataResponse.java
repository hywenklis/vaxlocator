package com.opensource.vaxlocator.integrations.response.opencagedata;

import java.util.List;


public record OpenCageDataResponse (List<ResultResponse> results) {}
