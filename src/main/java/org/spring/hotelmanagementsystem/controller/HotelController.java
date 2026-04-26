package org.spring.hotelmanagementsystem.controller;

import lombok.RequiredArgsConstructor;
import org.spring.hotelmanagementsystem.dto.GuestRequestDTO;
import org.spring.hotelmanagementsystem.dto.GuestResponseDTO;
import org.spring.hotelmanagementsystem.dto.HotelRequestDTO;
import org.spring.hotelmanagementsystem.dto.HotelResponseDTO;
import org.spring.hotelmanagementsystem.service.HotelService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/hotels")
public class HotelController {
    private final HotelService hotelService;
    @GetMapping
    public ResponseEntity<List<HotelResponseDTO>> getAllHotels() {
        return ResponseEntity.ok(hotelService.getAllHotels());
    }

    @GetMapping("/{id}")
    public ResponseEntity<HotelResponseDTO> getHotelById(@PathVariable Long id) {
        return ResponseEntity.ok(hotelService.getHotelById(id));
    }

    @PostMapping
    public ResponseEntity<HotelResponseDTO> createHotel(@RequestBody HotelRequestDTO hotelRequestDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(hotelService.createHotel(hotelRequestDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<HotelResponseDTO> updateHotel(@PathVariable Long id, @RequestBody HotelRequestDTO hotelRequestDTO) {
        return ResponseEntity.ok(hotelService.updateHotel(id, hotelRequestDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHotel(@PathVariable Long id) {
        hotelService.deleteHotel(id);
        return ResponseEntity.noContent().build();
    }
}

