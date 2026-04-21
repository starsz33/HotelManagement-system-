package org.spring.hotelmanagementsystem.repository;

import org.mapstruct.BeanMapping;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.spring.hotelmanagementsystem.models.Guest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GuestRepository extends JpaRepository<Guest,Long> {
    Optional<Guest> findByEmail(String email);
     boolean existsByEmail(String email);


}
