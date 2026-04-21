package org.spring.hotelmanagementsystem.service;

import lombok.RequiredArgsConstructor;
import org.spring.hotelmanagementsystem.dto.GuestRequestDTO;
import org.spring.hotelmanagementsystem.dto.GuestResponseDTO;
import org.spring.hotelmanagementsystem.exception.DuplicateResourceException;
import org.spring.hotelmanagementsystem.exception.ResourceNotFoundException;
import org.spring.hotelmanagementsystem.mapper.GuestMapper;
import org.spring.hotelmanagementsystem.models.Guest;
import org.spring.hotelmanagementsystem.repository.GuestRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GuestService {
    public final GuestRepository guestRepository;
    public final GuestMapper guestMapper;

    public GuestResponseDTO createGuest(GuestRequestDTO guestRequestDTO) {
        if(guestRepository.existsByEmail(guestRequestDTO.getEmail())){
            throw new DuplicateResourceException("Email already exist"+guestRequestDTO.getEmail());
        }
        Guest guest = guestMapper.toEntity(guestRequestDTO);
        Guest savedGuest = guestRepository.save(guest);
        return guestMapper.toResponse(savedGuest);
    }
    public GuestResponseDTO getGuestById(Long Id){
        Guest guest = guestRepository.findById(Id).orElseThrow(() ->
                new ResourceNotFoundException("Guest not found with id: " + Id));
        return guestMapper.toResponse(guest);
    }
    public List<GuestResponseDTO>getAllGuest(){
        return guestRepository.findAll().stream().map(guestMapper::toResponse).collect(Collectors.toList());
    }
    public GuestResponseDTO updateMember(Long id, GuestRequestDTO guestRequestDTO) {
        Guest guest = guestRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Guest not found with id: " + id));
        guestMapper.updateEntity(guestRequestDTO, guest);
        return guestMapper.toResponse(guestRepository.save(guest));
    }
    public void deleteGuest(Long id){
        if(!guestRepository.existsById(id))throw
                new ResourceNotFoundException("Guest not found"+ id);
        guestRepository.deleteById(id);
    }
}
