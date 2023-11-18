package com.opensource.vaxlocator.domains.repositories;

import com.opensource.vaxlocator.domains.entities.AddressEntity;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<AddressEntity, Long> {

  Optional<AddressEntity> findByPostalCode(String postalCode);
}
