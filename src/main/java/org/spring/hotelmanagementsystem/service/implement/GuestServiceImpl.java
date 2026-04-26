package org.spring.hotelmanagementsystem.service.implement;

import lombok.RequiredArgsConstructor;
import org.spring.hotelmanagementsystem.dto.GuestRequestDTO;
import org.spring.hotelmanagementsystem.dto.GuestResponseDTO;
import org.spring.hotelmanagementsystem.exception.DuplicateResourceException;
import org.spring.hotelmanagementsystem.exception.ResourceNotFoundException;
import org.spring.hotelmanagementsystem.mapper.GuestMapper;
import org.spring.hotelmanagementsystem.models.Guest;
import org.spring.hotelmanagementsystem.repository.GuestRepository;
import org.spring.hotelmanagementsystem.service.GuestService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.stream.Collectors;
@Service
@RequiredArgsConstructor
public class GuestServiceImpl implements GuestService {
    private final GuestRepository guestRepository;
    private final GuestMapper guestMapper;

    @Override
    public GuestResponseDTO createGuest(GuestRequestDTO guestRequestDTO) {
        if (guestRepository.existsByEmail(guestRequestDTO.getEmail())) {
            throw new DuplicateResourceException(
                    "Email already exists: " + guestRequestDTO.getEmail());
        }
        Guest guest = guestMapper.toEntity(guestRequestDTO);
        Guest savedGuest = guestRepository.save(guest);
        return guestMapper.toResponse(savedGuest);
    }

    @Override
    public GuestResponseDTO getGuestById(Long id) {
        Guest guest = guestRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Guest not found with id: " + id));
        return guestMapper.toResponse(guest);
    }

    @Override
    public List<GuestResponseDTO> getAllGuests() {
        return guestRepository.findAll()
                .stream()
                .map(guestMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public GuestResponseDTO updateGuest(Long id, GuestRequestDTO guestRequestDTO) {
        Guest guest = guestRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Guest not found with id: " + id));
        guestMapper.updateEntity(guestRequestDTO, guest);
        return guestMapper.toResponse(guestRepository.save(guest));
    }

    @Override
    public void deleteGuest(Long id) {
        if (!guestRepository.existsById(id))
            throw new ResourceNotFoundException(
                    "Guest not found with id: " + id);
        guestRepository.deleteById(id);
    }
}

