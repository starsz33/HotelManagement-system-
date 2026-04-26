package org.spring.hotelmanagementsystem.service;

import org.spring.hotelmanagementsystem.dto.HotelRequestDTO;
import org.spring.hotelmanagementsystem.dto.HotelResponseDTO;

import java.util.List;

public interface HotelService {
    HotelResponseDTO createHotel(HotelRequestDTO hotelRequestDTO);
    HotelResponseDTO getHotelById(Long id);
    List<HotelResponseDTO> getAllHotels();
    HotelResponseDTO updateHotel(Long id, HotelRequestDTO hotelRequestDTO);
    void deleteHotel(Long id);
}
