package com.opensource.vaxlocator.domains.repositories;

import com.opensource.vaxlocator.domains.entities.EstablishmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstablishmentRepository extends JpaRepository<EstablishmentEntity, Long> {

}
