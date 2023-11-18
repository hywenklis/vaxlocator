package com.opensource.vaxlocator.domains.dtos;

public record AddressDto(String city,
                         String municipality,
                         String postcode,
                         String region,
                         String state,
                         String suburb,
                         Double lat,
                         Double lng

) {

}