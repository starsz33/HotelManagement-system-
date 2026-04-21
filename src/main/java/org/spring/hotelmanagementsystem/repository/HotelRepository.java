package org.spring.hotelmanagementsystem.repository;

import org.spring.hotelmanagementsystem.models.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepository extends JpaRepository<Hotel,Long> {
}
