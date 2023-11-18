package com.opensource.vaxlocator.domains.repositories;

import com.opensource.vaxlocator.domains.entities.AddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<AddressEntity, Long> {

}
