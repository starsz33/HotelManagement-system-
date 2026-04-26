package org.spring.hotelmanagementsystem.service;

import org.spring.hotelmanagementsystem.dto.RoomRequestDTO;
import org.spring.hotelmanagementsystem.dto.RoomResponseDTO;

import java.util.List;

public interface RoomService {
    RoomResponseDTO createRoom(Long hotelId, RoomRequestDTO roomRequestDTO);
    RoomResponseDTO getRoomById(Long id);
    List<RoomResponseDTO> getRoomsByHotel(Long hotelId);
    List<RoomResponseDTO> getAvailableRooms(Long hotelId);
    RoomResponseDTO updateRoom(Long id, RoomRequestDTO roomRequestDTO);
    void deleteRoom(Long id);
}
