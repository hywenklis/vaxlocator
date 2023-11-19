package com.opensource.vaxlocator.integrations.response.opencagedata;

public record ComponentsResponse(String city,
                                 String municipality,
                                 String postcode,
                                 String region,
                                 String state,
                                 String suburb) {

}
