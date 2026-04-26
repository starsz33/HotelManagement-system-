package org.spring.hotelmanagementsystem.controller;

import lombok.RequiredArgsConstructor;
import org.spring.hotelmanagementsystem.dto.GuestRequestDTO;
import org.spring.hotelmanagementsystem.dto.GuestResponseDTO;
import org.spring.hotelmanagementsystem.dto.RoomRequestDTO;
import org.spring.hotelmanagementsystem.dto.RoomResponseDTO;
import org.spring.hotelmanagementsystem.service.GuestService;
import org.spring.hotelmanagementsystem.service.RoomService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/rooms")
public class RoomController {
    private final RoomService roomService;
    @GetMapping("/{id}")
    public ResponseEntity<RoomResponseDTO> getRoomById(@PathVariable Long id) {
        return ResponseEntity.ok(roomService.getRoomById(id));
    }
    @GetMapping("/hotel/{hotelId}")
    public ResponseEntity<List<RoomResponseDTO>> getRoomsByHotel(@PathVariable Long hotelId) {
        return ResponseEntity.ok(roomService.getRoomsByHotel(hotelId));
    }
    @GetMapping("/hotel/{hotelId}/available")
    public ResponseEntity<List<RoomResponseDTO>> getAvailableRooms(@PathVariable Long hotelId) {
        return ResponseEntity.ok(roomService.getAvailableRooms(hotelId));
    }
    @PostMapping("/hotel/{hotelId}")
    public ResponseEntity<RoomResponseDTO> createRoom(
            @PathVariable Long hotelId,
            @RequestBody RoomRequestDTO roomRequestDTO) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(roomService.createRoom(hotelId, roomRequestDTO));
    }
    @PutMapping("/{id}")
    public ResponseEntity<RoomResponseDTO> updateRoom(
            @PathVariable Long id,
            @RequestBody RoomRequestDTO roomRequestDTO) {
        return ResponseEntity.ok(roomService.updateRoom(id, roomRequestDTO));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRoom(@PathVariable Long id) {
        roomService.deleteRoom(id);
        return ResponseEntity.noContent().build();
    }
}
