package org.spring.hotelmanagementsystem.service;

import org.spring.hotelmanagementsystem.dto.GuestRequestDTO;
import org.spring.hotelmanagementsystem.dto.GuestResponseDTO;

import java.util.List;

public interface GuestService {
    GuestResponseDTO createGuest(GuestRequestDTO guestRequestDTO);
    GuestResponseDTO getGuestById(Long id);
    List<GuestResponseDTO> getAllGuests();
    GuestResponseDTO updateGuest(Long id, GuestRequestDTO guestRequestDTO);
    void deleteGuest(Long id);
}
