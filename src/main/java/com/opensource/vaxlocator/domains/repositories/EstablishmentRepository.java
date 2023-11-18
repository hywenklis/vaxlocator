package com.opensource.vaxlocator.domains.repositories;

import com.opensource.vaxlocator.domains.dtos.EstablishmentDomainDto;
import com.opensource.vaxlocator.domains.entities.EstablishmentEntity;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstablishmentRepository extends JpaRepository<EstablishmentEntity, Long> {

  Optional<List<EstablishmentDomainDto>> findByLatitudeAndLongitude(Double latitude, Double longitude);
}
