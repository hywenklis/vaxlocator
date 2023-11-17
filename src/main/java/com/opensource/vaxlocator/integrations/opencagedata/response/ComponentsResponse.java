package com.opensource.vaxlocator.integrations.opencagedata.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ComponentsResponse {
  private String city;
  private String municipality;
  private String postcode;
  private String region;
  private String state;
  private String suburb;
}
