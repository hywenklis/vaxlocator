package com.opensource.vaxlocator.service;

public interface DistanceCalculatorService {

  Double calculateDistance(
      final Double lat1,
      final Double lon1,
      final Double lat2,
      final Double lon2
  );
}
