package org.spring.hotelmanagementsystem.repository;

import org.spring.hotelmanagementsystem.models.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking,Long> {
}
