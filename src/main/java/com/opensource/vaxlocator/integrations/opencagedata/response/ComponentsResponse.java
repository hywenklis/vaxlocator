package com.opensource.vaxlocator.integrations.opencagedata.response;

public record ComponentsResponse(String city,
                                 String municipality,
                                 String postcode,
                                 String region,
                                 String state,
                                 String suburb) {

}
