package org.spring.hotelmanagementsystem.repository;

import org.spring.hotelmanagementsystem.models.Guest;
import org.spring.hotelmanagementsystem.models.Room;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface RoomRepository extends JpaRepository<Room,Long> {
    List<Room> findByHotelId(Long hotelId);

    List<Room> findByHotelIdAndAvailable(Long hotelId, boolean available);

}
