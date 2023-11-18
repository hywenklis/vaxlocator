package com.opensource.vaxlocator.domains.dtos;

public record AddressDto(String city,
                         String municipality,
                         String postalCode,
                         String region,
                         String state,
                         String suburb,
                         Double lat,
                         Double lng

) {

}
