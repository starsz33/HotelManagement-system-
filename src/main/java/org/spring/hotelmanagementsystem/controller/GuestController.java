package org.spring.hotelmanagementsystem.controller;

import lombok.RequiredArgsConstructor;
import org.spring.hotelmanagementsystem.dto.GuestRequestDTO;
import org.spring.hotelmanagementsystem.dto.GuestResponseDTO;
import org.spring.hotelmanagementsystem.service.GuestService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/guests")
@RequiredArgsConstructor
public class GuestController {

    private final GuestService guestService;

    @GetMapping
    public ResponseEntity<List<GuestResponseDTO>> getAllGuests() {
        return ResponseEntity.ok(guestService.getAllGuests());
    }

    @GetMapping("/{id}")
    public ResponseEntity<GuestResponseDTO> getGuestById(@PathVariable Long id) {
        return ResponseEntity.ok(guestService.getGuestById(id));
    }

    @PostMapping
    public ResponseEntity<GuestResponseDTO> createGuest(@RequestBody GuestRequestDTO guestRequestDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(guestService.createGuest(guestRequestDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<GuestResponseDTO> updateGuest(@PathVariable Long id, @RequestBody GuestRequestDTO guestRequestDTO) {
        return ResponseEntity.ok(guestService.updateGuest(id, guestRequestDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGuest(@PathVariable Long id) {
        guestService.deleteGuest(id);
        return ResponseEntity.noContent().build();
    }
}

