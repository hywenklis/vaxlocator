package com.opensource.vaxlocator.service.impls;

import com.opensource.vaxlocator.service.DistanceCalculatorService;
import org.springframework.stereotype.Service;

@Service
public class DistanceCalculatorServiceImpl implements DistanceCalculatorService {

  @Override
  public Double calculateDistance(
      final Double lat1,
      final Double lon1,
      final Double lat2,
      final Double lon2
  ) {
    double earthRadius = 6371;
    double dLat = Math.toRadians(lat2 - lat1);
    double dLon = Math.toRadians(lon2 - lon1);
    double a = Math.sin(dLat / 2) * Math.sin(dLat / 2) +
        Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) *
            Math.sin(dLon / 2) * Math.sin(dLon / 2);
    double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
    return earthRadius * c;
  }
}
